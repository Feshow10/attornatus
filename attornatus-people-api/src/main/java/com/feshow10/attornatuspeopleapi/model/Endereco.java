package com.feshow10.attornatuspeopleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_enderecos")
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    @Column
    private String logradouro;

    @Column
    private Integer numero;

    @Column
    private String cidade;

    @Column
    private Boolean enderecoPrincipal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}