package com.ecoguia.ecoguia_api.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.OffsetTime;

@Setter
@Getter
public class EcopontoBasicoModel {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Santo Amaro")
    private String nome;

    @Schema(example = "08:00:00")
    private LocalTime horarioAbertura;

    @Schema(example = "18:00:00")
    private LocalTime horarioFechamento;
}
