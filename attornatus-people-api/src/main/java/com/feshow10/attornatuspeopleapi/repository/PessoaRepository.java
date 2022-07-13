package com.feshow10.attornatuspeopleapi.repository;

import com.feshow10.attornatuspeopleapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
