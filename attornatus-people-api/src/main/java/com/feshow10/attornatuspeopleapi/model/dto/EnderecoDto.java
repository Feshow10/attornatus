package com.feshow10.attornatuspeopleapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class EnderecoDto {
    @NotBlank(message = "O campo não pode ficar vazio.")
    @Size(min = 8, max = 9, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String cep;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Positive(message = "O Id da pessoa precisa ser positivo.")
    private Long pessoaId;

    @NotBlank(message = "Preencha o campo corretamente.")
    private String logradouro;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 1, max = 9, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private Integer numero;

    @NotBlank(message = "Preencha o campo corretamente.")
    private String cidade;
}
