package org.example.project.api.projetos;

import org.example.project.api.departamentos.Departamento;

import java.time.LocalDate;
import java.util.Date;

public class Projeto {
    private Integer codigo;
    private String titulo;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private Departamento departamento;
    private static int countId = 1;

    public Projeto(String titulo, LocalDate data_inicio,
                   LocalDate data_fim, int cod_departamento) {
        this.codigo = countId++;
        this.setTitulo(titulo);
        this.setData_inicio(data_inicio);
        this.setData_fim(data_fim);
        this.departamento = new Departamento(cod_departamento);
    }

    public Projeto(Integer codigo, String titulo, LocalDate data_inicio,
            LocalDate data_fim, int cod_departamento) {
        this.setCodigo(codigo);
        this.setTitulo(titulo);
        this.setData_inicio(data_inicio);
        this.setData_fim(data_fim);
        this.departamento = new Departamento(cod_departamento);
    }

    public Projeto(Integer codigo) {
        this.codigo = codigo;
    }

    public void setCodigo(Integer codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("Codigo invalido.");
        }
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null) {
            throw new IllegalArgumentException("Titulo invalido.");
        }
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setData_inicio(LocalDate data_inicio) {
        if (data_inicio == null) {
            throw new IllegalArgumentException("Data invalida.");
        }
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_fim(LocalDate data_fim) {
        if (data_fim == null) {
            throw new IllegalArgumentException("Data invalida.");
        }
        this.data_fim = data_fim;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Titulo: " + titulo + ", " +
                "Data_inicio: " + data_inicio + ", Data_fim: " + data_fim + " " +
                "Cod_departamento: " + departamento.codigo + "";
    }
}
