package com.ecoguia.ecoguia_api.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EcopontoIdInput {

    @Schema(example = "1")
    @NotNull
    private Long id;
}
