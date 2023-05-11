package br.com.fiap.challengeeletro.repository;

import br.com.fiap.challengeeletro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
