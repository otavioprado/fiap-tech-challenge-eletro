package br.com.fiap.challengeeletro.repository;

import br.com.fiap.challengeeletro.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
