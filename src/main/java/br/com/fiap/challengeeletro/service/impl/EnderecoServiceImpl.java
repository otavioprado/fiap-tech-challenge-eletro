package br.com.fiap.challengeeletro.service.impl;

import br.com.fiap.challengeeletro.dto.EnderecoDTO;
import br.com.fiap.challengeeletro.mapper.EnderecoMapper;
import br.com.fiap.challengeeletro.model.Endereco;
import br.com.fiap.challengeeletro.repository.EnderecoRepository;
import br.com.fiap.challengeeletro.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    @Override
    public List<EnderecoDTO> buscarEnderecos() {
        log.info("Buscando endereços...");
        final List<Endereco> enderecos = enderecoRepository.findAll();

        return enderecoMapper.toDTO(enderecos);
    }

    @Override
    public EnderecoDTO buscarUmEnderecoPorId(final Long id) {
        log.info("Buscando endereço com id {}...", id);
        final Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            return enderecoMapper.toDTO(endereco.get());
        }

        return new EnderecoDTO();
    }

    @Override
    public Long cadastrarEndereco(final EnderecoDTO enderecoDTO) {
        log.info("Cadastrando endereço {}...", enderecoDTO);
        final Endereco endereco = enderecoRepository.save(
                enderecoMapper.toEntity(enderecoDTO)
        );

        return endereco.getId();
    }
}
