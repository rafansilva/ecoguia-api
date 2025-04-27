package com.ecoguia.ecoguia_api.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
public class CidadeInput {

    @Schema(example = "Uberlândia")
    @NotBlank
    private String nome;

    @Valid
    @NotNull
    private EstadoIdInput estado;

}