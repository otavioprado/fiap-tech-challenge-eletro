package br.com.fiap.challengeeletro.controller;

import br.com.fiap.challengeeletro.dto.EnderecoDTO;
import br.com.fiap.challengeeletro.service.EnderecoService;
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
@RequestMapping("/enderecos")
@RestController
public class EnderecosController {

    private final EnderecoService enderecoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EnderecoDTO>> buscarTodasenderecos() {
        List<EnderecoDTO> enderecos = enderecoService.buscarEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getById(@PathVariable Long id) {
        EnderecoDTO endereco = enderecoService.buscarUmEnderecoPorId(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> cadastrarendereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        Long idEndereco = enderecoService.cadastrarEndereco(enderecoDTO);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/enderecos/{id}")
                        .buildAndExpand(idEndereco)
                        .toUri()).build();
    }
}
