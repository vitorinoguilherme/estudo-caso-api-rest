package org.example.project.api.departamentos;

public class DepartamentoResponse {
    public int codigo;
    public String nome;
    public String sigla;

    public DepartamentoResponse(int codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    public DepartamentoResponse(Departamento departamento) {
        this.codigo = departamento.getCodigo();
        this.nome = departamento.getNome();
        this.sigla = departamento.getSigla();
    }

}
