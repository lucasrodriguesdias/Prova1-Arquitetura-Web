package com.example.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prova.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    
} 