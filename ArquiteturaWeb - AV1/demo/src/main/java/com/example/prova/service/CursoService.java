package com.example.prova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.prova.model.Curso;
import com.example.prova.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }
   
    public Curso save(Curso curso){
        return cursoRepository.save(curso);
    }

    public Optional<Curso> findById(Long id){
        return cursoRepository.findById(id);
    }

    public Optional<Curso> update(Long id, Curso updateCurso){
        return cursoRepository.findById(id).map(existingModel ->{
            existingModel.setNome(updateCurso.getNome());
            existingModel.setDescricao(updateCurso.getDescricao());
            existingModel.setCargaHoraria(updateCurso.getCargaHoraria());

            return cursoRepository.save(existingModel);
        });
    }

    public ResponseEntity<Void> delete(Long id){
        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
