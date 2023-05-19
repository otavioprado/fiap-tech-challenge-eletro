package br.com.fiap.challengeeletro.service.impl;

import br.com.fiap.challengeeletro.dto.EletrodomesticoDTO;
import br.com.fiap.challengeeletro.mapper.EletrodomesticoMapper;
import br.com.fiap.challengeeletro.model.Eletrodomestico;
import br.com.fiap.challengeeletro.repository.EletrodomesticoRepository;
import br.com.fiap.challengeeletro.service.EletrodomesticoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EletrodomesticoServiceImpl implements EletrodomesticoService {

    private final EletrodomesticoRepository eletrodomesticoRepository;
    private final EletrodomesticoMapper eletrodomesticoMapper;

    @Override
    public List<EletrodomesticoDTO> buscarEletrodomesticos() {
        log.info("Buscando eletrodomésticos...");
        final List<Eletrodomestico> eletrodomesticos = eletrodomesticoRepository.findAll();

        return eletrodomesticoMapper.toDTO(eletrodomesticos);
    }

    @Override
    public EletrodomesticoDTO buscarUmEletrodomesticoPorId(final Long id) {
        log.info("Buscando eletrodoméstico com id {}...", id);
        final Optional<Eletrodomestico> eletrodomestico = eletrodomesticoRepository.findById(id);
        if (eletrodomestico.isPresent()) {
            return eletrodomesticoMapper.toDTO(eletrodomestico.get());
        }

        return new EletrodomesticoDTO();
    }

    @Override
    public Long cadastrarEletrodomestico(final EletrodomesticoDTO eletrodomesticoDTO) {
        log.info("Cadastrando eletrodoméstico {}...", eletrodomesticoDTO);
        final Eletrodomestico eletrodomestico = eletrodomesticoRepository.save(
                eletrodomesticoMapper.toEntity(eletrodomesticoDTO)
        );

        return eletrodomestico.getId();
    }
}
