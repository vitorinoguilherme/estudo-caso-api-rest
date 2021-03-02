package org.example.project.api.departamentos;

public class Departamento {
    public int codigo;
    public String nome;
    public String sigla;
    private static int countId = 1;

    public Departamento(String nome, String sigla) {
        this.codigo = countId++;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Departamento(int codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Departamento(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public String toString() {
        return "" + codigo + ", " + nome + ", " + sigla + "";
    }
}
