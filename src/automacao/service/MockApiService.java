package automacao.service;

import automacao.model.Solicitacao;
import automacao.model.TipoSolicitacao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class MockApiService implements ApiService {

    @Override
    public List<Solicitacao> listarSolicitacoesPendentes(String funcionarioId) {
        List<Solicitacao> lista = new ArrayList<>();

        switch (funcionarioId) {
            case "1": // João — 8h05 (dentro da tolerância)
                lista.add(new Solicitacao("S1", "1", TipoSolicitacao.AJUSTE_HORARIO,
                        LocalTime.of(8, 0), LocalTime.of(16, 5)));
                break;
            case "2": // Maria — 8h40 (fora da tolerância)
                lista.add(new Solicitacao("S2", "2", TipoSolicitacao.AJUSTE_HORARIO,
                        LocalTime.of(9, 0), LocalTime.of(17, 40)));
                break;
            case "3": // Pedro — abono (pendente)
                lista.add(new Solicitacao("S3", "3", TipoSolicitacao.ABONO,
                        null, null));
                break;
            default:
                // ninguém encontrado — retorna lista vazia
                break;
        }

        return lista;
    }

    @Override
    public void enviarDecisao(String solicitacaoId, String decisao) {
        System.out.println("   [mock] Solicitação " + solicitacaoId + " => " + decisao);
    }
}
