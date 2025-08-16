package com.ecoguia.ecoguia_api.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoModel {

    @Schema(example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(example = "São Paulo")
    @JsonProperty("nome")
    private String nome;

}