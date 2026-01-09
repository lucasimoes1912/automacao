package automacao;

import automacao.controller.SolicitacaoController;

// Durante o desenvolvimento usei MockApiService por padrão. Quando tiver os dados do site Ahgora a ideia é trocar para o RealApiService.

public class App {

    public static void main(String[] args) {

        System.out.println("Iniciando automação (modo: mock).");

        // Simples e direto: controla tudo
        SolicitacaoController controller = new SolicitacaoController();

        // Se quiser testar com todos os exemplos do mock é só trocar o "CHEFIA A" por ""
        controller.processarSolicitacoes("");

        System.out.println("Processo finalizado.");
    }
}
