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
    public ResponseEntity<PessoaDto> salvar(@Valid @RequestBody PessoaDto dto) {
        dto = pessoaService.salvar(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
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

    @GetMapping("/{id}/enderecos")
    public ResponseEntity<List<Endereco>> getEnderecos(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.get(id);
        if (pessoa.isPresent()){
            return ResponseEntity.ok(pessoaService.getEnderecos(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> update(@PathVariable Long id,@Valid @RequestBody PessoaDto form) {
        Optional<Pessoa> pessoaAtual = pessoaService.get(id);
        if (pessoaAtual.isPresent()){
            PessoaDto pessoa = pessoaService.update(id,form);
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

}
