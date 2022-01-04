package com.dh.meli.diploma.dto;

import com.dh.meli.diploma.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaDTO {
    @NotNull
    @NotEmpty(message = "disciplina é obrigatória")
    private String descricao;
    @NotNull
    @NotEmpty(message = "nota é obrigatória")
    @Size(min = 1, max = 2, message = "nota deve ter entre 1 e 2 caracteres")
    @Pattern(regexp = "^[0-9]*$")
    @Min(value = 0, message = "nota deve ser maior que 0")
    @Max(value = 10, message = "nota deve ser menor que 10")
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
