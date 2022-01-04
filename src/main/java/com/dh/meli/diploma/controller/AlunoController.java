package com.dh.meli.diploma.controller;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.service.AlunoService;
import com.dh.meli.diploma.dto.AlunoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping("/cadastra")
    public ResponseEntity<AlunoDTO> cadastrarAluno(@Valid @RequestBody AlunoDTO dto) throws IOException {
        Aluno aluno = AlunoDTO.converte(dto);
        alunoService.adicionaAluno(aluno);
        return ResponseEntity.ok(AlunoDTO.converte(aluno));
    }

    @GetMapping("/exibirAlunos")
    public List<Aluno> exibirAlunos(){
        return alunoService.getListaAlunos();
    }

    @GetMapping("/exibirAluno/{nome}")
    public List<Aluno> exibirAluno(@PathVariable String nome) throws IOException {
        return alunoService.getAluno(nome);
    }

    @GetMapping("/exibirAlunoComMedia/{nome}")
    public List<Aluno> exibirAlunoComMedia(@PathVariable String nome) throws IOException {
        return alunoService.getAlunoComMedia(nome);
    }

    @PutMapping("/alterarAluno")
    public Aluno alteraAluno(@RequestBody Aluno aluno){
        return alunoService.alterarAluno(aluno);
    }

    @DeleteMapping("/removerAluno")
    public String removeAluno(@RequestBody Aluno aluno){
        return alunoService.removerAluno(aluno);
    }

}
