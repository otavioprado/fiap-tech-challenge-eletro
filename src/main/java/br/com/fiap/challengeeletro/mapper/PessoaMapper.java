package br.com.fiap.challengeeletro.mapper;

import br.com.fiap.challengeeletro.dto.PessoaDTO;
import br.com.fiap.challengeeletro.model.Pessoa;
import br.com.fiap.challengeeletro.model.Endereco;
import br.com.fiap.challengeeletro.repository.EnderecoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public abstract class PessoaMapper {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Mapping(target = "enderecoId", source = "endereco.id")
    public abstract PessoaDTO toDTO(Pessoa pessoa);

    @Mapping(target = "endereco", expression = "java(getEndereco(pessoaDTO.getEnderecoId()))")
    public abstract Pessoa toEntity(PessoaDTO pessoaDTO);

    public abstract List<PessoaDTO> toDTO(List<Pessoa> pessoas);

    protected Endereco getEndereco(Long enderecoId) {
        if (enderecoId != null) {
            return enderecoRepository.findById(enderecoId).orElse(null);
        }
        return null;
    }
}
