package com.feshow10.attornatuspeopleapi.model.dto;

import com.feshow10.attornatuspeopleapi.model.Pessoa;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class PessoaDto {

    public Pessoa transformaParaObjeto(){
        return new Pessoa(nome, dataDeNascimento);
    }

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;

    @NotNull(message = "Preencha o campo corretamente.")
    private LocalDateTime dataDeNascimento;
}
