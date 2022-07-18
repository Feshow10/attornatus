package com.feshow10.attornatuspeopleapi.controller;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoDto;
import com.feshow10.attornatuspeopleapi.service.impl.EnderecoServiceImpl;
import com.feshow10.attornatuspeopleapi.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Autowired
    private PessoaServiceImpl pessoaService;

    @PostMapping
    public ResponseEntity<Endereco> create(@Valid @RequestBody EnderecoDto form){
        Optional<Pessoa> pessoa = pessoaService.get(form.getPessoaId());
        if (pessoa.isPresent()){
            Endereco endereco = enderecoService.create(form);
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Endereco> getAll() {
        return enderecoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> get(@PathVariable Long id){
        Optional<Endereco> endereco = enderecoService.get(id);
        if (endereco.isPresent()){
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.notFound().build();
    }

}