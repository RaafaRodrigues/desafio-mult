package com.example.projeto.domain.entity;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa_fisica")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaFisica {

    @Id
    @Column(name = "id_p_fisica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nasc")
    private LocalDate dataNasc;

    @OneToOne
    @JoinColumn(name = "fk_estado_civil")
    private EstadoCivil estadoCivil;

    public PessoaFisica(String nome, LocalDate dataNasc, EstadoCivil estadoCivil) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.estadoCivil = estadoCivil;
    }

}
