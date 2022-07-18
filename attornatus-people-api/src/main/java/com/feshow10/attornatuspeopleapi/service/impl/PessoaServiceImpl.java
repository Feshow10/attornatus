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
    public PessoaDto salvar(PessoaDto dto) {
        Pessoa pessoa = parseDtoToEntity(dto);
        pessoa = pessoaRepository.save(pessoa);
        return parseEntityToDto(pessoa);
    }

    @Override
    public Optional<Pessoa> get(Long id) {
        return pessoaRepository.findById(id);
    }


    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    public List<Endereco> getEnderecos(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();
        return pessoa.getEnderecos();
    }

    @Override
    public PessoaDto update(Long id, PessoaDto form) {
        Optional<Pessoa> pessoaAtual = pessoaRepository.findById(id);
        Pessoa pessoaUpdate = parseDtoToEntity(form);
        pessoaAtual.get().setNome(pessoaUpdate.getNome());
        pessoaAtual.get().setDataDeNascimento(pessoaUpdate.getDataDeNascimento());
        return parseEntityToDto(pessoaRepository.save(pessoaAtual.get()));
    }

    private Pessoa parseDtoToEntity(PessoaDto dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setDataDeNascimento(dto.getDataDeNascimento());
//        pessoa.setEnderecos(dto.getEnderecos());
        return pessoa;
    }

    private PessoaDto parseEntityToDto(Pessoa pessoa) {
        PessoaDto dto = new PessoaDto();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setDataDeNascimento(pessoa.getDataDeNascimento());
//        dto.setEnderecos(pessoa.getEnderecos());
        return dto;
    }

}
