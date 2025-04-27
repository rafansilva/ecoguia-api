package com.ecoguia.ecoguia_api.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CidadeModel {

    @Schema(example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(example = "Uberlândia")
    @JsonProperty("nome")
    private String nome;

    private EstadoModel estado;

}