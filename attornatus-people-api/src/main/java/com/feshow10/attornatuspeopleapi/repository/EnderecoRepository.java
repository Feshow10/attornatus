package com.feshow10.attornatuspeopleapi.repository;

import com.feshow10.attornatuspeopleapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
