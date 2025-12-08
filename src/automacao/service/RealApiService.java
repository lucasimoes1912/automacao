package automacao.service;

import automacao.model.Solicitacao;
import java.util.List;

// É um esboço para quando tiver acesso a API da plataforma, somente será necessário realizar as trocas de informações.

public class RealApiService implements ApiService {

    private final String endpoint;
    private final String soapKey;

    public RealApiService(String endpoint, String soapKey) {
        this.endpoint = endpoint;
        this.soapKey = soapKey;
    }

    @Override
    public List<Solicitacao> listarSolicitacoesPendentes(String funcionarioId) {
        // TODO: montar envelope SOAP ou chamada REST conforme a spec da Ahgora
        // 1) Montar XML/JSON com AuthHeader (soapKey)
        // 2) Executar chamada HTTP (OkHttp, HttpClient)
        // 3) Fazer parse do retorno com XmlParser ou Gson
        // 4) Mapear para List<Solicitacao>
        throw new UnsupportedOperationException("Implementar após obter doc da API.");
    }

    @Override
    public void enviarDecisao(String solicitacaoId, String decisao) {
        // TODO: mesma coisa — enviar aprovação/reprovação para a API
        throw new UnsupportedOperationException("Implementar após obter doc da API.");
    }
}
