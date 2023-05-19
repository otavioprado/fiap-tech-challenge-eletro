package br.com.fiap.challengeeletro.repository;

import br.com.fiap.challengeeletro.model.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {
}
