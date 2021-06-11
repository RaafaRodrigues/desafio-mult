package com.example.projeto.service;


import com.example.projeto.domain.dto.DependenteDTO;
import com.example.projeto.domain.entity.Dependente;
import com.example.projeto.repository.DependenteRepository;
import com.example.projeto.util.Constantes;
import com.example.projeto.util.MetodosUteis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DependenteService {

    private final DependenteRepository dependenteRepository;

    public List<DependenteDTO> listarTodos(){
        List<Dependente> dependentes = dependenteRepository.findAllOrderById();
       return new MetodosUteis().transformarListDependentesDTO(dependentes);
    }

    public List<DependenteDTO> listarPorFk(Integer id){
        try {
                List<Dependente> dependentes = dependenteRepository.findAllDependentesFk(id);
                if(dependentes.size()> Constantes.ZERO ){
                    return new MetodosUteis().transformarListDependentesDTO(dependentes);
                }else{
                    throw  new Exception();
                }

        }catch (NullPointerException e) {
            return new ArrayList<>() ;
        }catch (NoSuchElementException e){
            return  new ArrayList<>() ;
        } catch (Exception e) {
            return  new ArrayList<>() ;
        }
    }

    public Boolean cadastrar(DependenteDTO  dependenteDTO){
        try {
            dependenteRepository.save(new MetodosUteis().transformarEntityDependente(dependenteDTO));
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    public Boolean atualizar(Integer id,DependenteDTO dependenteDTO) {
        try {
            if(dependenteRepository.existsById(id)) {
                Dependente dependente = dependenteRepository.findById(id).get();
                dependente.setNome(dependenteDTO.getNome());
                dependente.setCpf(dependenteDTO.getCpf());
                dependente.setFkPessoaFisica(dependenteDTO.getFkPessoaFisica());
                dependenteRepository.save(dependente);
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

        if(dependenteRepository.existsById(id)) {
            dependenteRepository.deleteById(id);
            return true;
        }else {
            return false;
        }

    }


}
