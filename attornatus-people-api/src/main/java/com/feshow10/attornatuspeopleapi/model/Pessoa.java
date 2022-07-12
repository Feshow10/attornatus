package com.feshow10.attornatuspeopleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_pessoas")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private LocalDateTime dataDeNascimento;

    @OneToMany(mappedBy = "cep", fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();
}
