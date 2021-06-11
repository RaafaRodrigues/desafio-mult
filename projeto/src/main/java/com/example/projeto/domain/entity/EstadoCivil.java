package com.example.projeto.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "estado_civil")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstadoCivil {


    @Id
    @Column(name = "id_e_civil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoCivil;

    @Column(name = "descricao")
    private String descricao;



}
