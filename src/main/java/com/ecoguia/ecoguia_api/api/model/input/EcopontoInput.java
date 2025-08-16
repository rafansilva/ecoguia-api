package com.ecoguia.ecoguia_api.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.OffsetTime;

@Getter
@Setter
public class EcopontoInput {

    @Schema(example = "Santo Amaro")
    @NotBlank
    private String nome;

    @Schema(example = "08:00:00")
    private LocalTime horarioAbertura;

    @Schema(example = "18:00:00")
    private LocalTime horarioFechamento;

    @Valid
    @NotNull
    private EnderecoInput endereco;
}
