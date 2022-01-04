package com.dh.meli.diploma.service;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.entity.Disciplina;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AlunoService {
    List<Aluno> listaAlunos = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final String PATH = "alunos.json";

    public Aluno adicionaAluno(Aluno aluno) throws IOException {
        listaAlunos.add(aluno);
        objectMapper.writeValue(new File(PATH), listaAlunos);
        return aluno;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public List<Aluno> getAluno(String nome) throws IOException {
        File file = new File(PATH);
        FileInputStream is = new FileInputStream(file);
        listaAlunos = Arrays.asList(objectMapper.readValue(is, Aluno[].class));
        return listaAlunos;
    }

    public Aluno alterarAluno(Aluno aluno){
        for (Aluno al: listaAlunos){
            if(al.getNome().equals(aluno.getNome())){
                listaAlunos.set(listaAlunos.indexOf(al), aluno);
                return aluno;
            }
        }
        return null;
    }

    public String removerAluno(Aluno aluno){
        for (Aluno al: listaAlunos){
            if(al.getNome().equals(aluno.getNome())){
                listaAlunos.remove(al);
                return "ALUNO REMOVIDO\n\n" + al.toString();
            }
        }
        return "Aluno não encontrado!!!";
    }


    public List<Aluno> getAlunoComMedia(String nome) {
        return null;
    }
}
