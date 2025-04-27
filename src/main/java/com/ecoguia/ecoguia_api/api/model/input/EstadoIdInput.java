package com.ecoguia.ecoguia_api.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Setter
@Getter
public class EstadoIdInput {

    @Schema(example = "1")
    @NotNull
    private Long id;

}