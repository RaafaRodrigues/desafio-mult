package com.example.projeto.domain.dto;

import com.example.projeto.domain.entity.EstadoCivil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ApiModel(value = "Pessoa Fisica DTO")
public class PessoaFisicaDTO {

    @ApiModelProperty(value = "Id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "Nome", example = "João")
    private String nome;

    @ApiModelProperty(value = "Data Nascimento", example = "1996-09-22")
    private LocalDate dataNasc;

    @ApiModelProperty(value = "Estado civil", example = "Solteiro(a)")
    private EstadoCivil estadoCivil;
}
