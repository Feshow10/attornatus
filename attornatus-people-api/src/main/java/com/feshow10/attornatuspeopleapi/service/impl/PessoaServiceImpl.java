package com.feshow10.attornatuspeopleapi.service.impl;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import com.feshow10.attornatuspeopleapi.repository.PessoaRepository;
import com.feshow10.attornatuspeopleapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> get(Long id) {
        return pessoaRepository.findById(id);
    }


    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override //revisar esse método
    public List<Endereco> getEnderecos(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();
        return pessoa.getEnderecos();
    }

    @Override
    public Pessoa update(Long id, PessoaDto formUpdate) {
        Optional<Pessoa> pessoaAtual = pessoaRepository.findById(id);
        pessoaAtual.get().setNome(formUpdate.getNome());
        pessoaAtual.get().setDataDeNascimento(formUpdate.getDataDeNascimento());
        return pessoaRepository.save(pessoaAtual.get());
    }

}
