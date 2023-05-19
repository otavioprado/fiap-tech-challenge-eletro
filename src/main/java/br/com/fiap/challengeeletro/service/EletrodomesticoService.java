package br.com.fiap.challengeeletro.service;

import br.com.fiap.challengeeletro.dto.EletrodomesticoDTO;

import java.util.List;

public interface EletrodomesticoService {
    List<EletrodomesticoDTO> buscarEletrodomesticos();

    EletrodomesticoDTO buscarUmEletrodomesticoPorId(Long id);

    Long cadastrarEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO);
}
