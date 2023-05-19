package br.com.fiap.challengeeletro.service;

import br.com.fiap.challengeeletro.dto.EnderecoDTO;

import java.util.List;

public interface EnderecoService {
    List<EnderecoDTO> buscarEnderecos();

    EnderecoDTO buscarUmEnderecoPorId(Long id);

    Long cadastrarEndereco(EnderecoDTO enderecoDTO);
}
