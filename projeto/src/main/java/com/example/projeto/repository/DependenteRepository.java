package com.example.projeto.repository;


import com.example.projeto.domain.entity.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependenteRepository extends JpaRepository<Dependente,Integer> {
}
