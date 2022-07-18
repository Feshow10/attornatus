package com.feshow10.attornatuspeopleapi.service;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    PessoaDto salvar(PessoaDto form); //OK

    Optional<Pessoa> get(Long id); //OK

    List<Pessoa> getAll(); //OK

    List<Endereco> getEnderecos(Long id);

    PessoaDto update(Long id, PessoaDto formUpdate);

}
