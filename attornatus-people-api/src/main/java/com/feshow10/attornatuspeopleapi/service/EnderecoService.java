package com.feshow10.attornatuspeopleapi.service;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoDto;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoPrincipalDto;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

    Endereco create(EnderecoDto form);

    Optional<Endereco> get(Long id);

    List<Endereco> getAll();

    Endereco update(EnderecoPrincipalDto formUpdate);
}