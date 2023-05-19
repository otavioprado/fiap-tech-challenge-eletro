package br.com.fiap.challengeeletro.controller;

import br.com.fiap.challengeeletro.dto.EletrodomesticoDTO;
import br.com.fiap.challengeeletro.service.EletrodomesticoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/eletrodomesticos")
@RestController
public class EletrodomesticosController {

    private final EletrodomesticoService eletrodomesticoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EletrodomesticoDTO>> buscarTodosEletrodomesticos() {
        List<EletrodomesticoDTO> eletrodomesticos = eletrodomesticoService.buscarEletrodomesticos();
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EletrodomesticoDTO> getById(@PathVariable Long id) {
        EletrodomesticoDTO eletrodomestico = eletrodomesticoService.buscarUmEletrodomesticoPorId(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> cadastrarEletrodomestico(@Valid @RequestBody EletrodomesticoDTO eletrodomesticoDTO) {
        Long idEletrodomestico = eletrodomesticoService.cadastrarEletrodomestico(eletrodomesticoDTO);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/eletrodomesticos/{id}")
                .buildAndExpand(idEletrodomestico)
                .toUri()).build();
    }
}
