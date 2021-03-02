package org.example.project.api.departamentos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartamentoRequest {
    @NotNull
    @Size(min = 2, max = 100)
    @NotBlank
    public String nome;

    @NotNull
    @Size(min = 2, max = 4)
    @NotBlank
    public String sigla;
}
