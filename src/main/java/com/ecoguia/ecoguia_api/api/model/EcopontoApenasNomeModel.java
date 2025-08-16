package com.ecoguia.ecoguia_api.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EcopontoApenasNomeModel {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Santo Amaro")
    private String nome;
}
