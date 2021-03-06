package org.example.project.api.funcionarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class FuncionarioRequest {
    @CPF
    public String CPF;

    @NotNull
    @Size(min = 2, max = 100)
    @NotBlank
    public String nome;

    @NotNull
    @Email
    public String email;

    @NotNull
    public Integer cod_departamento;
}
