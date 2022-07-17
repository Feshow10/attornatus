package com.feshow10.attornatuspeopleapi.service;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    Pessoa salvar(PessoaDto form);

    Optional<Pessoa> get(Long id);

    List<Pessoa> getAll();

    List<Endereco> getEnderecos(Long id);

    Pessoa update(Long id, PessoaDto formUpdate);

}
