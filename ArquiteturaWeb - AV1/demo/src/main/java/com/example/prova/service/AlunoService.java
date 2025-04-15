package com.example.prova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.prova.model.Aluno;
import com.example.prova.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }
   
    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> findById(Long id){
        return alunoRepository.findById(id);
    }

    public Optional<Aluno> update(Long id, Aluno updateAluno){
        return alunoRepository.findById(id).map(existingModel ->{
            existingModel.setNome(updateAluno.getNome());
            existingModel.setEmail(updateAluno.getEmail());
            existingModel.setDataNascimento(updateAluno.getDataNascimento());

            return alunoRepository.save(existingModel);
        });
    }

    public ResponseEntity<Void> delete(Long id){
        if(alunoRepository.existsById(id)){
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
