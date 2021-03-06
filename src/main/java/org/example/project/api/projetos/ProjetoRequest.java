package org.example.project.api.projetos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;


import java.time.LocalDate;

public class ProjetoRequest {
    @NotNull
    @Size(min = 2, max = 100)
    @NotBlank
    public String titulo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent
    public LocalDate data_inicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Future
    public LocalDate data_fim;

    @NotNull
    public int cod_departamento;

    public Boolean checkIfDateIsGreaterThanAnotherDate() {
        return data_fim.isBefore(data_inicio);
    }
}
