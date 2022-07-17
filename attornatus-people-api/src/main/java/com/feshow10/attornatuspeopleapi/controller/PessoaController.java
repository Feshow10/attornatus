package com.feshow10.attornatuspeopleapi.controller;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import com.feshow10.attornatuspeopleapi.model.Pessoa;
import com.feshow10.attornatuspeopleapi.model.dto.PessoaDto;
import com.feshow10.attornatuspeopleapi.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@Valid @RequestBody PessoaDto dto) {
        Pessoa pessoa = pessoaService.salvar(dto.transformaParaObjeto());
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pessoa> getAll(){
        return pessoaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> get(@Valid @PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.get(id);
        if (pessoa.isPresent()){
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/enderecos/{id}")
    public List<Endereco> getEnderecos(@PathVariable Long id){
        return pessoaService.getEnderecos(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@Valid @PathVariable Long id, @RequestBody PessoaDto form) {
        Optional<Pessoa> pessoaAtual = pessoaService.get(id);
        if (pessoaAtual.isPresent()){
            Pessoa pessoa = pessoaService.update(id, form);
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

}
