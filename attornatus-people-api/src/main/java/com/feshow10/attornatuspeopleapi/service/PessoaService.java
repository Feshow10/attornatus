package com.feshow10.attornatuspeopleapi.service;

import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    Pessoa create(PessoaDto form);

    Optional<Pessoa> get(Long id);

    List<Pessoa> getAll();

    //Pessoa update(Long id, PessoaUpdateForm formUpdate);

}
