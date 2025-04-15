package com.example.prova.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan("com.example.prova.model")
@Entity 
@Data
@AllArgsConstructor 
@NoArgsConstructor

public class Curso {

    @Id //Define o campo "id" como chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente
    private Long id; 
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
}