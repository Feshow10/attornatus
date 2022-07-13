package com.feshow10.attornatuspeopleapi.service;

import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import com.feshow10.attornatuspeopleapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public void save(PessoaDto novaPessoa){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(novaPessoa.getNome());
        pessoa.setDataDeNascimento(novaPessoa.getDataDeNascimento());
        repository.save(pessoa);
    }

}
