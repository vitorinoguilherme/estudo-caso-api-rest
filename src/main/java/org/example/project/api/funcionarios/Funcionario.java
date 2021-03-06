package org.example.project.api.funcionarios;

import org.example.project.api.departamentos.Departamento;

public class Funcionario {
    private String CPF;
    private String nome;
    private String email;
    private Departamento departamento;
    private int id;
    private static int countId = 1;

    public Funcionario(int id, String CPF, String nome, String email, Integer cod_departamento) {
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.departamento = new Departamento(cod_departamento);
    }

    public Funcionario(String CPF, String nome, String email, Integer cod_departamento) {
        this.id = countId++;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.departamento = new Departamento(cod_departamento);
    }

    public Funcionario(String CPF, String nome, String email, Departamento departamento) {
        this.setCPF(CPF);
        this.setNome(nome);
        this.setEmail(email);
        this.departamento = departamento;
    }

    public Funcionario(String CPF) {
        this.CPF = CPF;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setCPF(String CPF) {
        if (CPF.length() != 11) {
            throw new IllegalArgumentException("CPF invalido.");
        }
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome invalido.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email invalido.");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + CPF + ", \nEmail: " + email + ", COD_DEPARTAMENTO: " + departamento.codigo + "\n";
    }

    public int getId() {
        return this.id;
    }
}
