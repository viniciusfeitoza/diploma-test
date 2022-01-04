package com.dh.meli.diploma.entity;

import lombok.Builder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
public class Disciplina {
    private String descricao;
    @NotNull
    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 1, max = 2, message = "Nota não permitida.")
    @Pattern(regexp = "^[0-1]*$")
    private Double nota;

    public Disciplina(String descricao, Double nota) {
        this.descricao = descricao;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "descricao='" + descricao + '\'' +
                ", nota=" + nota +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
