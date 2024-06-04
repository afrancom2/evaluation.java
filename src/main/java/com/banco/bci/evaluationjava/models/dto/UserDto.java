package com.banco.bci.evaluationjava.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {
    private String name;
    @NotBlank(message = "El correo electronico es obligatorio")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.cl$", message = "El correo electronico no es valido")
    private String email;
    @NotBlank(message = "El password es obligatorio")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*/])(?=\\S+$).{8,}$", message = "La contraseña no cumple con los requisitos mínimos")
    private String password;
    private List<PhoneDto> phones;
}
