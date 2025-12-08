package automacao.service;

import automacao.model.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Nesse caso está puxando a lista de funcionários do mock, durante a aplicação real ele chamaria o ApiService para puxar os funcionários reais.

public class FuncionarioService {

    private final List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioService() {
        // Exemplos criados para testar o programa!
        funcionarios.add(new Funcionario("1", "João Silva", "CHEFIA A"));
        funcionarios.add(new Funcionario("2", "Maria Santos", "CHEFIA B"));
        funcionarios.add(new Funcionario("3", "Pedro Duarte", "CHEFIA A"));
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios);
    }

    public List<Funcionario> filtrarPorChefia(String chefia) {
        return funcionarios.stream()
                .filter(f -> f.getChefia().equalsIgnoreCase(chefia))
                .collect(Collectors.toList());
    }
}
