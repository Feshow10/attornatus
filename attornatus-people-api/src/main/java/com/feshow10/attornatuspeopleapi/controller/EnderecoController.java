package com.feshow10.attornatuspeopleapi.controller;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.dto.EnderecoDto;
import com.feshow10.attornatuspeopleapi.service.impl.EnderecoServiceImpl;
import com.feshow10.attornatuspeopleapi.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Endereco create(@Valid @RequestBody EnderecoDto form){
        return enderecoService.create(form);
    }

    @GetMapping
    public List<Endereco> getAll() {
        return enderecoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Endereco> get(@PathVariable Long id){
        return enderecoService.get(id);
    }

}
