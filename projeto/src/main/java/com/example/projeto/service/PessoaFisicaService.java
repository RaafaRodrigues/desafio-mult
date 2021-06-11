package com.example.projeto.service;


import com.example.projeto.util.MetodosUteis;
import com.example.projeto.domain.dto.PessoaFisicaDTO;
import com.example.projeto.domain.entity.PessoaFisica;
import com.example.projeto.repository.PessoaFisicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaFisicaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;

    public List<PessoaFisicaDTO> listarTodos(){
            List<PessoaFisica> pessoas = pessoaFisicaRepository.findAllOrderById();
            List<PessoaFisicaDTO> pessoaFisicaDTOS = new ArrayList<>();
            pessoas.stream().map(pessoa ->
                    pessoaFisicaDTOS.add(new MetodosUteis().transformarDTO(pessoa))

            ).collect(Collectors.toList());

        return pessoaFisicaDTOS;
    }

    public PessoaFisicaDTO listarPorId(Integer id){
        try {
            if(pessoaFisicaRepository.existsById(id)) {
                PessoaFisica entidade = pessoaFisicaRepository.findById(id).get();
                PessoaFisicaDTO pessoa = new MetodosUteis().transformarDTO(entidade);
                return pessoa;
            }else{
                throw new Exception();
            }

        }catch (NullPointerException e) {
            return new PessoaFisicaDTO();
        }catch (NoSuchElementException e){
            return new PessoaFisicaDTO();
        } catch (Exception e) {
           return new PessoaFisicaDTO();
        }
    }

    public Boolean cadastrar(PessoaFisicaDTO  pessoaFisicaDTO){
            try {
                pessoaFisicaRepository.save(new MetodosUteis().transformarEntity(pessoaFisicaDTO));
                return true;
            }catch (NullPointerException e){
                return false;
            }
    }

    public Boolean atualizar(Integer id,PessoaFisicaDTO pessoaFisicaDTO) {
        try {
            if(pessoaFisicaRepository.existsById(id)) {
                PessoaFisica pessoa = pessoaFisicaRepository.findById(id).get();
                pessoa.setNome(pessoaFisicaDTO.getNome());
                pessoa.setDataNasc(pessoaFisicaDTO.getDataNasc());
                pessoa.setEstadoCivil(pessoaFisicaDTO.getEstadoCivil());
                pessoaFisicaRepository.save(pessoa);
                return true;
            }else{
                throw new Exception();
            }
        }catch (NullPointerException n){
            return false;
        }catch (Exception e){
            return false;
        }

    }

    public Boolean deletar(Integer id){

            if(pessoaFisicaRepository.existsById(id)) {
                pessoaFisicaRepository.deleteById(id);
                return true;
            }else {
                return false;
            }

    }

}
