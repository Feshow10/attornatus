package com.feshow10.attornatuspeopleapi.controller;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaUpdateDto;
import com.feshow10.attornatuspeopleapi.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl service;

    @PostMapping
    public Pessoa salvar(@Valid @RequestBody PessoaDto form){
        return service.salvar(form);
    }

    @GetMapping
    public List<Pessoa> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping("/enderecos/{id}")
    public List<Endereco> getEnderecos(@PathVariable Long id){
        return service.getEnderecos(id);
    }

    @PutMapping("/update/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody PessoaUpdateDto form) {
        return service.update(id, form);
    }

}
