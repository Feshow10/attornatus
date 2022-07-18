package com.feshow10.attornatuspeopleapi.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class EnderecoPrincipalDto {

    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "O Id da pessoa precisa ser positivo.")
    private Long pessoaId;

    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "O Id da pessoa precisa ser positivo.")
    private Long enderecoId;

}