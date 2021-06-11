package com.example.projeto.domain.dto;

import com.example.projeto.domain.entity.PessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DependenteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private PessoaFisica fkPessoaFisica;
}
