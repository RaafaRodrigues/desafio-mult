package com.example.projeto.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstadoCivilDTO {

    @ApiModelProperty(value = "Id", example = "1")
    private Integer idEstadoCivil;

    @ApiModelProperty(value = "Descricão", example = "Solteiro(a)")
    private String descricao;
}
