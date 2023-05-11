package br.com.fiap.challengeeletro.mapper;

import br.com.fiap.challengeeletro.dto.PessoaDTO;
import br.com.fiap.challengeeletro.model.Pessoa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PessoaMapper {
    PessoaDTO toDTO(Pessoa pessoa);
    Pessoa toEntity(PessoaDTO pessoaDTO);
    List<PessoaDTO> toDTO(List<Pessoa> pessoas);
}
