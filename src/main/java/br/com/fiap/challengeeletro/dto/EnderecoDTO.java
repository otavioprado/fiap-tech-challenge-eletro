package br.com.fiap.challengeeletro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO {

    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private String id;

    @NotBlank
    @Size(max = 255)
    private String rua;

    @Range(min = 0, max = 10000)
    private int numero;

    @NotBlank
    @Size(max = 100)
    private String bairro;

    @NotBlank
    @Size(max = 100)
    private String cidade;

    @NotBlank
    @Size(max = 2)
    private String estado;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public String getId() {
        return id;
    }
}

