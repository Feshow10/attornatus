package com.feshow10.attornatuspeopleapi.service.impl;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoDto;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import com.feshow10.attornatuspeopleapi.repository.EnderecoRepository;
import com.feshow10.attornatuspeopleapi.repository.PessoaRepository;
import com.feshow10.attornatuspeopleapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoDto salvar(EnderecoDto dto) {
        Endereco endereco = parseDtoToEntity(dto);
        endereco = enderecoRepository.save(endereco);

        return parseEntityToDto(endereco);
    }

    @Override
    public Optional<Endereco> get(Long id) {
        return enderecoRepository.findById(id);
    }


    @Override
    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    private Endereco parseDtoToEntity(EnderecoDto dto) {
        Endereco endereco = new Endereco();
        Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId()).orElse(null);
        endereco.setPessoa(pessoa);
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setCep(dto.getCep());
        endereco.setNumero(dto.getNumero());
        endereco.setCidade(dto.getCidade());
        endereco.setEnderecoPrincipal(dto.getEnderecoPrincipal());

        return endereco;
    }

    private EnderecoDto parseEntityToDto(Endereco endereco) {
        EnderecoDto dto = new EnderecoDto();
        dto.setPessoaId(endereco.getId());
        dto.setLogradouro(endereco.getLogradouro());
        dto.setCep(endereco.getCep());
        dto.setCep(endereco.getCep());
        dto.setNumero(endereco.getNumero());
        dto.setCidade(endereco.getCidade());
        dto.setEnderecoPrincipal(endereco.getEnderecoPrincipal());

        return dto;
    }

}
