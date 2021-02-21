package org.example.project.api.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotNull
    @NotBlank
    @Size(min=2, max=100)
    public String name;

    @NotNull
    @Email
    public String email;

    @NotNull
    @NotBlank
    @Size(min=6, max=100)
    public String password;
}
