package com.example.projeto.repository;


import com.example.projeto.domain.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica,Integer> {



    @Query(value = "select * from pessoa_fisica  as p order by p.id_p_fisica" ,nativeQuery = true )
    List<PessoaFisica> findAllOrderById();

}
