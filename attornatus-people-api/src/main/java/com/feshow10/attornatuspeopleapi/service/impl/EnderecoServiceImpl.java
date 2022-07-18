package com.feshow10.attornatuspeopleapi.service.impl;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoDto;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoPrincipalDto;
import com.feshow10.attornatuspeopleapi.repository.EnderecoRepository;
import com.feshow10.attornatuspeopleapi.repository.PessoaRepository;
import com.feshow10.attornatuspeopleapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco create(EnderecoDto form) {
        Endereco endereco = new Endereco();
        Pessoa pessoa = pessoaRepository.findById(form.getPessoaId()).orElse(null);
        if (form.getEnderecoPrincipal()){
            assert pessoa != null;
            enderecoPrincipal(pessoa.getId());
        }
        endereco.setPessoa(pessoa);
        endereco.setLogradouro(form.getLogradouro());
        endereco.setCep(form.getCep());
        endereco.setNumero(form.getNumero());
        endereco.setCidade(form.getCidade());
        endereco.setEnderecoPrincipal(form.getEnderecoPrincipal());

        return enderecoRepository.save(endereco);
    }

    @Override
    public Optional<Endereco> get(Long id) {
        return enderecoRepository.findById(id);
    }

    @Override
    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco update(EnderecoPrincipalDto formUpdate) {
        Endereco enderecoAtualizado = enderecoRepository.getReferenceById(formUpdate.getEnderecoId());
        enderecoPrincipal(formUpdate.getPessoaId());
        enderecoAtualizado.setEnderecoPrincipal(true);
        return enderecoRepository.save(enderecoAtualizado);
    }

    private void enderecoPrincipal(Long id){
        Optional<List<Endereco>> enderecos = Optional.ofNullable(pessoaRepository.findById(id).get().getEnderecos());
        Iterator<Endereco> iterator = enderecos.get().iterator();
        while (iterator.hasNext()) {
            Endereco endereco = iterator.next();
            if (endereco.getEnderecoPrincipal()) {
                endereco.setEnderecoPrincipal(false);
            }
        }
    }
}