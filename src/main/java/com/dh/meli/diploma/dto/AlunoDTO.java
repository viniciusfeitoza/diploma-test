package com.dh.meli.diploma.dto;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
    @NotNull
    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 8, max = 50, message = "tamanho minimo 8 e maximo 50")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String nome;
    @Valid
    private List<Disciplina> listaDisciplinas;




    public static Aluno converte(AlunoDTO dto) {
        Aluno aluno = Aluno.builder()
                .nome(dto.getNome())
                .listaDisciplinas(dto.getListaDisciplinas())
                .build();

        return aluno;
    }

    public static AlunoDTO converte(Aluno aluno) {
        return AlunoDTO.builder()
                .nome(aluno.getNome())
                .listaDisciplinas(aluno.getListaDisciplinas())
                .build();
    }

    public static List<AlunoDTO> converte(List<Aluno> usuarios){
        return usuarios.stream().map(u -> converte(u)).collect(Collectors.toList());
    }
}
