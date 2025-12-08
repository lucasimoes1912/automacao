package automacao.model;

import java.time.LocalTime;

// Se a API da plataforma trouxer múltiplos intervalos tem que trocar par por List<TimeRange>.

public class Solicitacao {

    private final String id;
    private final String funcionarioId;
    private final TipoSolicitacao tipo;
    private final LocalTime entrada;
    private final LocalTime saida;

    public Solicitacao(String id, String funcionarioId, TipoSolicitacao tipo, LocalTime entrada, LocalTime saida) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.tipo = tipo;
        this.entrada = entrada;
        this.saida = saida;
    }

    public String getId() { return id; }
    public String getFuncionarioId() { return funcionarioId; }
    public TipoSolicitacao getTipo() { return tipo; }
    public LocalTime getEntrada() { return entrada; }
    public LocalTime getSaida() { return saida; }
}
