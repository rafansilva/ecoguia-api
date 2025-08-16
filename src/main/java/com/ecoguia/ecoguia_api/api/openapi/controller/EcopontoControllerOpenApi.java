package com.ecoguia.ecoguia_api.api.openapi.controller;

import com.ecoguia.ecoguia_api.api.model.EcopontoApenasNomeModel;
import com.ecoguia.ecoguia_api.api.model.EcopontoBasicoModel;
import com.ecoguia.ecoguia_api.api.model.EcopontoModel;
import com.ecoguia.ecoguia_api.api.model.input.EcopontoInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Ecopontos")
public interface EcopontoControllerOpenApi {

    @Operation(summary = "Lista ecopontos", parameters = {
            @Parameter(name = "projecao",
                    description = "Nome da projeção",
                    example = "apenas-nome",
                    in = ParameterIn.QUERY,
                    required = false
            )
    })
    List<EcopontoBasicoModel> listar();

    @Operation(hidden = true)
    List<EcopontoApenasNomeModel> listarApenasNomes();

    @Operation(summary = "Busca um ecoponto por ID", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "ID do ecoponto inválido", content = {
                    @Content(schema = @Schema(ref = "Problema")) }),
            @ApiResponse(responseCode = "404", description = "Ecoponto não encontrado", content = {
                    @Content(schema = @Schema(ref = "Problema")) }),
    })
    EcopontoModel buscar(
            @Parameter(description = "ID de um ecoponto", example = "1", required = true) Long ecopontoId);

    @Operation(summary = "Cadastra um ecoponto", responses = {
            @ApiResponse(responseCode = "201", description = "Ecoponto cadastrado"),
    })
    EcopontoModel adicionar(
            @RequestBody(description = "Representação de um novo ecoponto", required = true) EcopontoInput ecopontoInput);

    @Operation(summary = "Atualiza um ecoponto por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Ecoponto atualizado"),
            @ApiResponse(responseCode = "404", description = "Ecoponto não encontrado", content = {
                    @Content(schema = @Schema(ref = "Problema")) }),
    })
    EcopontoModel atualizar(
            @Parameter(description = "ID de um ecoponto", example = "1", required = true) Long ecopontoId,
            @RequestBody(description = "Representação de um ecoponto com os novos dados", required = true) EcopontoInput ecopontoInput);

    @Operation(summary = "Ativa um ecoponto por ID", responses = {
            @ApiResponse(responseCode = "204", description = "Ecoponto ativado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ecoponto não encontrado", content = {
                    @Content(schema = @Schema(ref = "Problema")) }),
    })
    ResponseEntity<Void> ativar(@Parameter(description = "ID de um ecoponto", example = "1", required = true) Long ecopontoId);

    @Operation(summary = "Desativa um ecoponto por ID", responses = {
            @ApiResponse(responseCode = "204", description = "Ecoponto inativado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ecoponto não encontrado", content = {
                    @Content(schema = @Schema(ref = "Problema")) }),
    })
    ResponseEntity<Void> inativar(@Parameter(description = "ID de um ecoponto", example = "1", required = true) Long ecopontoId);

    @Operation(summary = "Ativa múltiplos ecopontos", responses = {
            @ApiResponse(responseCode = "204", description = "Ecopontos ativados com sucesso"),
    })
    ResponseEntity<Void> ativarMultiplos(
            @RequestBody(description = "IDs de ecopontos", required = true) List<Long> ecopontoIds);

    @Operation(summary = "Inativa múltiplos ecoponto", responses = {
            @ApiResponse(responseCode = "204", description = "Ecopontos desativados com sucesso"),
    })
    ResponseEntity<Void> inativarMultiplos(
            @RequestBody(description = "IDs de ecopontos", required = true) List<Long> ecopontoIds);

    @Operation(summary = "Abre um ecoponto por ID", responses = {
            @ApiResponse(responseCode = "204", description = "Ecoponto aberto com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ecoponto não encontrado", content = {
                    @Content(schema = @Schema(ref = "Problema")) }),
    })
    ResponseEntity<Void> abrir(@Parameter(description = "ID de um ecoponto", example = "1", required = true) Long ecopontoId);

    @Operation(summary = "Fecha um ecoponto por ID", responses = {
            @ApiResponse(responseCode = "204", description = "Ecoponto fechado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ecoponto não encontrado", content = {
                    @Content(schema = @Schema(ref = "Problema")) }),
    })
    ResponseEntity<Void> fechar(@Parameter(description = "ID de um ecoponto", example = "1", required = true) Long ecopontoId);

}
