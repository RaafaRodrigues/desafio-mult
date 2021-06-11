package com.example.projeto.util;

import com.example.projeto.domain.dto.*;
import com.example.projeto.domain.entity.Dependente;
import com.example.projeto.domain.entity.EstadoCivil;
import com.example.projeto.domain.entity.PessoaFisica;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MetodosUteis {

    public PessoaFisicaDTO transformarDTO(PessoaFisica pessoaFisica){
        return  new PessoaFisicaDTO(pessoaFisica.getId(),pessoaFisica.getNome(),pessoaFisica.getDataNasc(),pessoaFisica.getEstadoCivil());
    }
    public PessoaFisica transformarEntity(PessoaFisicaDTO pessoaFisicaDTO){
        return new PessoaFisica(pessoaFisicaDTO.getId(),pessoaFisicaDTO.getNome(),pessoaFisicaDTO.getDataNasc(),pessoaFisicaDTO.getEstadoCivil());
    }
    public PessoaFisicaDTO transformarDTOPessoaFisica(PessoaFisica pessoaFisica){
        return  new PessoaFisicaDTO(pessoaFisica.getId(),
                pessoaFisica.getNome(),pessoaFisica.getDataNasc(),
               pessoaFisica.getEstadoCivil());
    }

    /*public PessoaFisicaDTO transformarDTOPessoaFisica(PessoaFisica pessoaFisica){
        return  new PessoaFisicaDTO(pessoaFisica.getId(),
                pessoaFisica.getNome(),pessoaFisica.getDataNasc(),
                this.transformarDTOEstadoCivil(pessoaFisica.getEstadoCivil()));
    }

    public PessoaFisica transformarEntityPessoaFisicaPost(PessoaFisicaPostDTO pessoaFisicaPostDTO){
        return new PessoaFisica(pessoaFisicaPostDTO.getNome(),pessoaFisicaPostDTO.getDataNasc(),
                this.transformarEntityEstadoCivil(pessoaFisicaPostDTO.getEstadoCivil()));
    }
    public PessoaFisica transformarEntityPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO){
        return new PessoaFisica(
                pessoaFisicaDTO.getNome(),
                pessoaFisicaDTO.getDataNasc(),
                this.transformarEntityEstadoCivil(pessoaFisicaDTO.getEstadoCivil()));
    }

    public Dependente transformarEntityDependente(DependentetDTO dependentePostDTO){
        return new Dependente(dependentePostDTO.getNome(),
                dependentePostDTO.getCpf(),
                this.transformarEntityPessoaFisicaPost(dependentePostDTO.getFkPessoaFisica()));
    }

    public EstadoCivil transformarEntityEstadoCivil(EstadoCivilDTO estadoCivilDTO){
        return new EstadoCivil(estadoCivilDTO.getIdEstadoCivil(),estadoCivilDTO.getDescricao());
    }
    public EstadoCivilDTO transformarDTOEstadoCivil(EstadoCivil estadoCivil){
        return new EstadoCivilDTO(estadoCivil.getIdEstadoCivil(),estadoCivil.getDescricao());
    }

    public List<DependenteDTO> transformarListDependentesDTO(List<Dependente> dependentes){
        List<DependenteDTO> dependentesDTO = new ArrayList<>();
        dependentes.stream().map(dependente ->
                dependentesDTO.add(new MetodosUteis().transformarDTODependente(dependente))
        ).collect(Collectors.toList());
        return dependentesDTO;
    }*/
    public PessoaFisica transformarEntityPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO){
        return new PessoaFisica(
                pessoaFisicaDTO.getNome(),
                pessoaFisicaDTO.getDataNasc(),
                pessoaFisicaDTO.getEstadoCivil());
    }
    public Dependente transformarEntityDependente(DependenteDTO dependentePostDTO){
        return new Dependente(dependentePostDTO.getNome(),
                dependentePostDTO.getCpf(),
               dependentePostDTO.getFkPessoaFisica());
    }
    public DependenteDTO transformarDTODependente(Dependente dependente){
        return  new DependenteDTO(dependente.getId(),dependente.getNome(),dependente.getCpf(),dependente.getFkPessoaFisica());
    }
    public List<DependenteDTO> transformarListDependentesDTO(List<Dependente> dependentes){
        List<DependenteDTO> dependentesDTO = new ArrayList<>();
        dependentes.stream().map(dependente ->
                dependentesDTO.add(new MetodosUteis().transformarDTODependente(dependente))
        ).collect(Collectors.toList());
        return dependentesDTO;
    }
}
