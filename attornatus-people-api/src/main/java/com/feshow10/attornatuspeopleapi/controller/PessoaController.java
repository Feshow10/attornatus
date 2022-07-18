package com.feshow10.attornatuspeopleapi.controller;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import com.feshow10.attornatuspeopleapi.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {
    @Autowired
    private PessoaServiceImpl service;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> salvar(@Valid @RequestBody PessoaDto form){
        return new ResponseEntity<>(service.salvar(form), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pessoa> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Pessoa>> get(@PathVariable Long id){
        Optional<Pessoa> pessoa = service.get(id);
        if (pessoa.isPresent()){
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{id}/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Endereco>> getEnderecos(@PathVariable Long id){
        Optional<Pessoa> pessoa = service.get(id);
        if (pessoa.isPresent()){
            return ResponseEntity.ok(pessoa.get().getEnderecos());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> update(@PathVariable Long id,@Valid @RequestBody PessoaDto form) {
        Optional<Pessoa> pessoaAtual = service.get(id);
        if (pessoaAtual.isPresent()){
            Pessoa pessoaAtualizada = service.update(id, form);
            return ResponseEntity.ok(pessoaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }
}