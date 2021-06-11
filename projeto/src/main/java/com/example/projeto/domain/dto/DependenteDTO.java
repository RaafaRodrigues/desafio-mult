package com.example.projeto.domain.dto;

import com.example.projeto.domain.entity.PessoaFisica;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Dependente DTO")
public class DependenteDTO {


    private Integer id;
    private String nome;
    private String cpf;
    private PessoaFisica fkPessoaFisica;
}
