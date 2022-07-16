package com.feshow10.attornatuspeopleapi.service.impl;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaUpdateDto;
import com.feshow10.attornatuspeopleapi.repository.PessoaRepository;
import com.feshow10.attornatuspeopleapi.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository repository;

    @Override
    public Pessoa salvar(PessoaDto form) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(form.getNome());
        pessoa.setDataDeNascimento(form.getDataDeNascimento());
        return repository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> get(Long id) {
        return repository.findById(id);
    }


    @Override
    public List<Pessoa> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Endereco> getEnderecos(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow();
        return pessoa.getEnderecos();
    }

    @Override
    public Pessoa update(Long id, PessoaUpdateDto formUpdate) {
        Optional<Pessoa> pessoaAtual = repository.findById(id);
        pessoaAtual.get().setNome(formUpdate.getNome());
        pessoaAtual.get().setDataDeNascimento(formUpdate.getDataDeNascimento());
        return repository.save(pessoaAtual.get());
    }

}
