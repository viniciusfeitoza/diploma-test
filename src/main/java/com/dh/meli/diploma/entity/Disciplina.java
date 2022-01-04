package com.dh.meli.diploma.entity;

import lombok.Builder;

@Builder
public class Disciplina {
    private String descricao;
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
