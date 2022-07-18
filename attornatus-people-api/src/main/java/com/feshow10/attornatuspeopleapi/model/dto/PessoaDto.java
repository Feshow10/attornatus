package com.feshow10.attornatuspeopleapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.feshow10.attornatuspeopleapi.model.Endereco;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class PessoaDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;

    @NotNull(message = "Preencha o campo corretamente.")
    private LocalDateTime dataDeNascimento;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private List<Endereco> enderecos = new ArrayList<>();
}
