package automacao.controller;

import automacao.model.Funcionario;
import automacao.model.Solicitacao;
import automacao.service.FuncionarioService;
import automacao.service.MockApiService;
import automacao.service.ApiService;
import automacao.service.RealApiService;

import java.util.List;

// Controla as chamadas, no momento usa o mock.

public class SolicitacaoController {

    private final FuncionarioService funcionarioService;
    private final ApiService apiService; // interface: permite trocar impl.

    // Construtor padrão usa Mock. Troque aqui se quiser RealApiService.
    public SolicitacaoController() {
        this.funcionarioService = new FuncionarioService();
        this.apiService = new MockApiService();
    }

    // Processa solicitações filtrando por chefia (se chefia == null ou "" puxa todos os funcionários)
    public void processarSolicitacoes(String chefia) {

        List<Funcionario> funcionarios;

        if (chefia == null || chefia.trim().isEmpty()) {
            funcionarios = funcionarioService.listarTodos();
            System.out.println("Processando TODOS os funcionários.");
        } else {
            funcionarios = funcionarioService.filtrarPorChefia(chefia);
            System.out.println("Processando funcionários da chefia: " + chefia);
        }

        System.out.println("Funcionários carregados: " + funcionarios.size());

        for (Funcionario f : funcionarios) {
            System.out.println("\nIniciando análise para: " + f.getNome() + " (ID: " + f.getId() + ")");
            List<Solicitacao> pendentes = apiService.listarSolicitacoesPendentes(f.getId());

            if (pendentes == null || pendentes.isEmpty()) {
                System.out.println("   (nenhuma solicitação pendente)");
                continue;
            }

            for (Solicitacao s : pendentes) {
                System.out.println("   Analise -> Solicitação " + s.getId() + " | Tipo: " + s.getTipo());
                String decisao = aplicarRegrasBasicas(s);
                apiService.enviarDecisao(s.getId(), decisao);
                System.out.println("   Resultado: " + decisao);
            }
        }

        System.out.println("\nProcessamento encerrado.");
    }

    private String aplicarRegrasBasicas(Solicitacao s) {

        // 1) Se não for ajuste de horário, permanece pendente
        if (s.getTipo() != null && s.getTipo() != automacao.model.TipoSolicitacao.AJUSTE_HORARIO) {
            return "PENDENTE";
        }

        // 2) Se entrada ou saida nulos — não há como analisar
        if (s.getEntrada() == null || s.getSaida() == null) {
            return "PENDENTE";
        }

        // 3) Calculo simples (em minutos)
        long minutos = java.time.Duration.between(s.getEntrada(), s.getSaida()).toMinutes();

        final int IDEAL = 480;   // 8h
        final int TOL = 11;      // ±11

        int diff = (int) Math.abs(minutos - IDEAL);

        System.out.println("   Minutos trabalhados = " + minutos + " (diff = " + diff + ")");

        if (diff <= TOL) {
            return "APROVADO";
        } else {
            return "RECUSADO";
        }
    }
}
