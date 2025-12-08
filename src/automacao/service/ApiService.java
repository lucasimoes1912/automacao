package automacao.service;

import automacao.model.Solicitacao;
import java.util.List;

// Onde a interação com a API ocorre.

public interface ApiService {

    List<Solicitacao> listarSolicitacoesPendentes(String funcionarioId);

    void enviarDecisao(String solicitacaoId, String decisao);
}
