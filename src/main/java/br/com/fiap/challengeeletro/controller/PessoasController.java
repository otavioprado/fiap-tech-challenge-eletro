package br.com.fiap.challengeeletro.controller;

import br.com.fiap.challengeeletro.dto.PessoaDTO;
import br.com.fiap.challengeeletro.service.PessoaService;
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
@RequestMapping("/pessoas")
@RestController
public class PessoasController {

    private final PessoaService pessoaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PessoaDTO>> buscarTodasPessoas() {
        List<PessoaDTO> pessoas = pessoaService.buscarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable Long id) {
        PessoaDTO pessoa = pessoaService.buscarUmaPessoaPorId(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> cadastrarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {
        Long idPessoa = pessoaService.cadastrarPessoa(pessoaDTO);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/pessoas/{id}")
                        .buildAndExpand(idPessoa)
                        .toUri()).build();
    }
}
