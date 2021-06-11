package com.example.projeto.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dependentes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dependente {
    @Id
    @Column(name = "id_dependente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome",length = 80)
    private String nome;

    @Column(name = "cpf" ,length = 11)
    private String cpf;

   // @Column(name = "fk_p_fisica")
    @ManyToOne
    @JoinColumn(name= "fk_p_fisica")
    private PessoaFisica fkPessoaFisica;

    public Dependente(String nome, String cpf, PessoaFisica fkPessoaFisica) {
        this.nome = nome;
        this.cpf = cpf;
        this.fkPessoaFisica = fkPessoaFisica;
    }
}
