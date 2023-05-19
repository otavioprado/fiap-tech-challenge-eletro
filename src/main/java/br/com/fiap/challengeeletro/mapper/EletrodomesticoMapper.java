package br.com.fiap.challengeeletro.mapper;

import br.com.fiap.challengeeletro.dto.EletrodomesticoDTO;
import br.com.fiap.challengeeletro.model.Eletrodomestico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EletrodomesticoMapper {
    EletrodomesticoDTO toDTO(Eletrodomestico eletrodomestico);
    Eletrodomestico toEntity(EletrodomesticoDTO eletrodomesticoDTO);
    List<EletrodomesticoDTO> toDTO(List<Eletrodomestico> eletrodomesticos);
}
