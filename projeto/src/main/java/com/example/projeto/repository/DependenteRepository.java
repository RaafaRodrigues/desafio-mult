package com.example.projeto.repository;


import com.example.projeto.domain.entity.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DependenteRepository extends JpaRepository<Dependente,Integer> {

    @Query(value = "select * from dependente  as d order by d.id_dependente" ,nativeQuery = true )
    List<Dependente> findAllOrderById();
    @Query(value = "select * from dependente  as d where d.fk_p_fisica = :fk_pessoa" ,nativeQuery = true )
    List<Dependente> findAllDependentesFk(@Param("fk_pessoa") Integer id);
}
