package br.com.fiap.challengeeletro.service.impl;

import br.com.fiap.challengeeletro.dto.PessoaDTO;
import br.com.fiap.challengeeletro.mapper.PessoaMapper;
import br.com.fiap.challengeeletro.model.Pessoa;
import br.com.fiap.challengeeletro.repository.PessoaRepository;
import br.com.fiap.challengeeletro.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    @Override
    public List<PessoaDTO> buscarPessoas() {
        log.info("Buscando pessoas...");
        final List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoaMapper.toDTO(pessoas);
    }

    @Override
    public PessoaDTO buscarUmaPessoaPorId(final Long id) {
        log.info("Buscando pessoa com id {}...", id);
        final Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return pessoaMapper.toDTO(pessoa.get());
        }

        return new PessoaDTO();
    }

    @Override
    public Long cadastrarPessoa(final PessoaDTO pessoaDTO) {
        log.info("Cadastrando pessoa {}...", pessoaDTO);
        final Pessoa pessoa = pessoaRepository.save(
                pessoaMapper.toEntity(pessoaDTO)
        );

        return pessoa.getId();
    }
}
