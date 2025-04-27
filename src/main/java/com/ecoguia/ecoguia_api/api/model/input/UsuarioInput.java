package com.ecoguia.ecoguia_api.api.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

    @Schema(example = "João da Silva")
    @NotBlank
    @JsonProperty("nome")
    private String nome;

    @Schema(example = "joao.ger@ecoguia.com.br")
    @NotBlank
    @Email
    @JsonProperty("email")
    private String email;
}
