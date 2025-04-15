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

import com.example.prova.model.Curso;
import com.example.prova.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAll(){
        return cursoService.findAll();
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso){
        return cursoService.save(curso);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCurso(@PathVariable Long id){
        return cursoService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso){
        return cursoService.update(id, curso)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return cursoService.delete(id);
    }
}
