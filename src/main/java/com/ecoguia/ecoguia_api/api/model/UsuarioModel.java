package com.ecoguia.ecoguia_api.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModel {

    @Schema(example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(example = "João da Silva")
    @JsonProperty("nome")
    private String nome;

    @Schema(example = "joao.ger@ecoguia.com.br")
    @JsonProperty("email")
    private String email;

    private EnderecoModel enderecoModel;
}
