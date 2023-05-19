package br.com.fiap.challengeeletro.model;

import br.com.fiap.challengeeletro.enums.Sexo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private String email;
    private String telefone;

    @OneToOne
    private Endereco endereco;
    private String parentesco;

}
