package com.ecoguia.ecoguia_api.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoInput {

    @Schema(example = "38400-000")
    @NotBlank
    private String cep;

    @Schema(example = "Rua Floriano Peixoto")
    @NotBlank
    private String logradouro;

    @Schema(example = "\"1500\"")
    @NotBlank
    private String numero;

    @Schema(example = "Apto 901")
    private String complemento;

    @Schema(example = "Centro")
    @NotBlank
    private String bairro;

    @Schema(example = "-23.5489")
    private String latitude;

    @Schema(example = "-46.6388")
    private String longitude;

    @Valid
    @NotNull
    private CidadeIdInput cidade;

}
