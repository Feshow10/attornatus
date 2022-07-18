package com.feshow10.attornatuspeopleapi.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class PessoaRequestDto {

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;

    @NotNull(message = "Preencha o campo corretamente.")
    private LocalDateTime dataDeNascimento;
}
