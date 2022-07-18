package com.feshow10.attornatuspeopleapi.controller;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoDto;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoPrincipalDto;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import com.feshow10.attornatuspeopleapi.service.impl.EnderecoServiceImpl;
import com.feshow10.attornatuspeopleapi.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Autowired
    private PessoaServiceImpl pessoaService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> create(@Valid @RequestBody EnderecoDto form){
        Optional<Pessoa> pessoa = pessoaService.get(form.getPessoaId());
        if (pessoa.isPresent()){
            Endereco endereco = enderecoService.create(form);
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Endereco> getAll() {
        return enderecoService.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Endereco>> get(@PathVariable Long id){
        Optional<Endereco> endereco = enderecoService.get(id);
        if (endereco.isPresent()){
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/principal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> update(@Valid @RequestBody EnderecoPrincipalDto form) {
        Optional<Pessoa> pessoaAtual = pessoaService.get(form.getPessoaId());
        if (pessoaAtual.isPresent()){
            Optional<Endereco> enderecoAtual = enderecoService.get(form.getEnderecoId());
            if (enderecoAtual.isPresent()){
                Endereco enderecoAtualizado = enderecoService.update(form);
                return ResponseEntity.ok(enderecoAtualizado);
            }
        }
        return ResponseEntity.notFound().build();
    }


}