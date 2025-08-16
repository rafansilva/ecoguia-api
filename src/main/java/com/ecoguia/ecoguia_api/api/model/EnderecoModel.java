package com.ecoguia.ecoguia_api.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoModel {

    @Schema(example = "38400-000")
    private String cep;

    @Schema(example = "Rua Floriano Peixoto")
    private String logradouro;

    @Schema(example = "\"1500\"")
    private String numero;

    @Schema(example = "Apto 901")
    private String complemento;

    @Schema(example = "Centro")
    private String bairro;

    @Schema(example = "-23.5489")
    private String latitude;

    @Schema(example = "-46.6388")
    private String longitude;

    private CidadeResumoModel cidade;

}

