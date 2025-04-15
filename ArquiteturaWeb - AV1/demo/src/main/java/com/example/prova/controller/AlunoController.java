package com.example.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova.model.Aluno;
import com.example.prova.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAll(){
        return alunoService.findAll();
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno){
        return alunoService.save(aluno);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Long id){
        return alunoService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno){
        return alunoService.update(id, aluno)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return alunoService.delete(id);
    }
}
