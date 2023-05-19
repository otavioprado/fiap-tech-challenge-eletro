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
public class EletrodomesticoDTO {

    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private String id;

    @NotBlank
    @Size(max = 255)
    private String nome;

    @NotBlank
    @Size(max = 255)
    private String modelo;

    @Range(min = 1, max = 100000)
    private int potenciaEmWatts;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public String getId() {
        return id;
    }
}

