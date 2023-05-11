package br.com.fiap.challengeeletro.service;

import br.com.fiap.challengeeletro.dto.PessoaDTO;

import java.util.List;

public interface PessoaService {
    List<PessoaDTO> buscarPessoas();

    PessoaDTO buscarUmaPessoaPorId(Long id);

    Long cadastrarPessoa(PessoaDTO pessoaDTO);
}
