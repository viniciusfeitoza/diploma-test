package com.dh.meli.diploma.dto;

import com.dh.meli.diploma.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaDTO {

    private String descricao;
    private Double nota;

    public static Disciplina converte(DisciplinaDTO dto) {
        Disciplina disciplina = Disciplina.builder()
                .descricao(dto.getDescricao())
                .nota(dto.getNota())
                .build();

        return disciplina;
    }

    public static DisciplinaDTO converte(Disciplina disciplina) {
        return DisciplinaDTO.builder()
                .descricao(disciplina.getDescricao())
                .nota(disciplina.getNota())
                .build();
    }
}
