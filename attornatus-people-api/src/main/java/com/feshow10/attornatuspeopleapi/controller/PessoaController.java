package com.feshow10.attornatuspeopleapi.controller;

import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
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
    public Pessoa create(@Valid @RequestBody PessoaDto form){
        return service.create(form);
    }

    @GetMapping
    public List<Pessoa> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> get(@PathVariable Long id){
        return service.get(id);
    }

}
