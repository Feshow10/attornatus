package com.feshow10.attornatuspeopleapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class EnderecoDto {
    @NotBlank(message = "O campo não pode ficar vazio.")
    @Size(min = 8, max = 9, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String cep;

    @NotBlank(message = "Preencha o campo corretamente.")
    private String logradouro;

    @NotNull(message = "Preencha o campo corretamente.")
    private Integer numero;

    @NotBlank(message = "Preencha o campo corretamente.")
    private String cidade;

    @NotNull(message = "Preencha o campo corretamente.")
    private Boolean enderecoPrincipal;

    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "O Id da pessoa precisa ser positivo.")
    private Long pessoaId;
}