package automacao.model;

// A princípio mostra só os campos necessários, da para incluir e-mail, cargo, etc.

public class Funcionario {

    private final String id;
    private final String nome;
    private final String chefia;

    public Funcionario(String id, String nome, String chefia) {
        this.id = id;
        this.nome = nome;
        this.chefia = chefia;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getChefia() { return chefia; }

    @Override
    public String toString() {
        return id + " - " + nome + " (" + chefia + ")";
    }
}
