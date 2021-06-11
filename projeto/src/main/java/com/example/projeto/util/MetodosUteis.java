package com.example.projeto.util;

import com.example.projeto.domain.dto.PessoaFisicaDTO;
import com.example.projeto.domain.entity.PessoaFisica;

public class MetodosUteis {

    public PessoaFisicaDTO transformarDTO(PessoaFisica pessoaFisica){
        return  new PessoaFisicaDTO(pessoaFisica.getId(),pessoaFisica.getNome(),pessoaFisica.getDataNasc(),pessoaFisica.getEstadoCivil());
    }
    public PessoaFisica transformarEntity(PessoaFisicaDTO pessoaFisicaDTO){
       return new PessoaFisica(pessoaFisicaDTO.getId(),pessoaFisicaDTO.getNome(),pessoaFisicaDTO.getDataNasc(),pessoaFisicaDTO.getEstadoCivil());
    }
}
