package com.ecoguia.ecoguia_api.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@Builder
@Schema(name = "Problema")
public class Problem {

    @Schema(example = "400")
    @JsonProperty("status")
    private Integer status;

    @Schema(example = "https://ecoguia.com.br/dados-invalidos")
    @JsonProperty("type")
    private String type;

    @Schema(example = "Dados inválidos")
    @JsonProperty("title")
    private String title;

    @Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
    @JsonProperty("detail")
    private String detail;

    @Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
    @JsonProperty("user_message")
    private String userMessage;

    @Schema(example = "2025-03-23T11:21:50.902245498Z")
    @JsonProperty("timestamp")
    private OffsetDateTime timestamp;

    @Schema(description = "Lista de objetos ou campos que geraram o erro")
    @JsonProperty("object")
    private List<Object> objects;


    @Builder
    @Getter
    @Schema(name = "ObjetoProblema")
    public static class Object {

        @Schema(example = "usuario")
        @JsonProperty("name")
        private String name;

        @Schema(example = "O usuario é inválido")
        @JsonProperty("user_message")
        private String userMessage;
    }
}
