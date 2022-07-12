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
    @Column(unique = true)
    private String cep;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Column
    private String logradouro;

    @Column
    private String numero;

    @Column
    private String cidade;
}
