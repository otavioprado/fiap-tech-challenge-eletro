package br.com.fiap.challengeeletro.mapper;

import br.com.fiap.challengeeletro.dto.EnderecoDTO;
import br.com.fiap.challengeeletro.model.Endereco;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EnderecoMapper {
    EnderecoDTO toDTO(Endereco endereco);
    Endereco toEntity(EnderecoDTO pessoaDTO);
    List<EnderecoDTO> toDTO(List<Endereco> enderecos);
}
