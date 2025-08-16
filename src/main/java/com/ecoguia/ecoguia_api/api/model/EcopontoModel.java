package com.ecoguia.ecoguia_api.api.model;

import com.ecoguia.ecoguia_api.domain.model.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalTime;
import java.time.OffsetTime;

@Setter
@Getter
public class EcopontoModel {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Santo Amaro")
    private String nome;

    private Boolean ativo;

    private Boolean aberto;

    @Schema(example = "08:00:00")
    private LocalTime horarioAbertura;

    @Schema(example = "18:00:00")
    private LocalTime horarioFechamento;

    private Endereco endereco;
}
