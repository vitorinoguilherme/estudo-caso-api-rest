package org.example.project.api.funcionarios;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Funcionario save(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        return funcionario;
    }

    public List<Funcionario> getAll() {
        return this.funcionarios;
    }

    public Funcionario getById(int id) {
        return this.funcionarios.stream().filter(funcionario -> id == funcionario.getId())
                .findAny()
                .orElse(null);
    }

    public Funcionario update(Funcionario newFuncionario) {
        Funcionario funcionarioFound = this.getById(newFuncionario.getId());
        funcionarios.set(funcionarios.indexOf(funcionarioFound), newFuncionario);
        return newFuncionario;
    }

    public void delete(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }
}
