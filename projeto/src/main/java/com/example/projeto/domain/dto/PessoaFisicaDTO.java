package com.example.projeto.domain.dto;

import com.example.projeto.domain.entity.EstadoCivil;
import com.example.projeto.domain.entity.PessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class PessoaFisicaDTO {
    private Integer id;
    private String nome;
    private LocalDate dataNasc;
    private EstadoCivil estadoCivil;



}
