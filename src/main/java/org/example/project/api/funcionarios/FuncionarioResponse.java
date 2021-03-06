package org.example.project.api.funcionarios;

public class FuncionarioResponse {
    public String CPF;
    public String nome;
    public String email;
    public Integer cod_departamento;
    public int id;

    public FuncionarioResponse(String CPF, String nome, String email, Integer cod_departamento) {
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.cod_departamento = cod_departamento;
    }

    public FuncionarioResponse(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.CPF = funcionario.getCPF();
        this.nome = funcionario.getNome();
        this.email = funcionario.getEmail();
        this.cod_departamento = funcionario.getDepartamento().getCodigo();
    }
}
