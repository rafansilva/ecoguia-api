package com.ecoguia.ecoguia_api.api.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class EstadoInput {

    @Schema(example = "Minas Gerais")
    @NotBlank
    @JsonProperty("nome")
    private String nome;

}
