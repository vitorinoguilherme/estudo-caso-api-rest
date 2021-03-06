package org.example.project.api.projetos;


import java.time.LocalDate;

public class ProjetoResponse {
    public int id;
    public String titulo;
    public LocalDate data_inicio;
    public LocalDate data_fim;
    public int cod_departamento;

    public ProjetoResponse(int id, String titulo, LocalDate data_inicio, LocalDate data_fim, int cod_departamento) {
        this.id = id;
        this.titulo = titulo;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.cod_departamento = cod_departamento;
    }

    public ProjetoResponse(Projeto projeto) {
        this.id = projeto.getCodigo();
        this.titulo = projeto.getTitulo();
        this.data_inicio = projeto.getData_inicio();
        this.data_fim = projeto.getData_fim();
        this.cod_departamento = projeto.getDepartamento().getCodigo();
    }


}
