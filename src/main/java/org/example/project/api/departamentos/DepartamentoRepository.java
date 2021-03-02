package org.example.project.api.departamentos;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepository {
    private List<Departamento> departamentos = new ArrayList<>();

    public Departamento save(Departamento departamento) {
        this.departamentos.add(departamento);
        return departamento;
    }

    public List<Departamento> getAll() {
        return this.departamentos;
    }

    public Departamento getById(int id) {
        return this.departamentos.stream()
                .filter(departamento -> departamento.getCodigo() == id)
                .findAny()
                .orElse(null);

    }

    public Departamento update(Departamento departamento) {
        Departamento departamentoFound = this.getById(departamento.getCodigo());
        departamentos.set(departamentos.indexOf(departamentoFound), departamento);
        return departamento;
    }

    public void delete(Departamento departamento) {
        departamentos.remove(departamento);
    }
}
