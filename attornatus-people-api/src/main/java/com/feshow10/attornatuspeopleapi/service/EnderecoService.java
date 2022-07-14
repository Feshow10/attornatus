package com.feshow10.attornatuspeopleapi.service;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoDto;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

    Endereco create(EnderecoDto form);

    List<Endereco> get(Long id);

    List<Endereco> getAll();
}
