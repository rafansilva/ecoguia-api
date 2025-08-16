package com.ecoguia.ecoguia_api.api.openapi.controller;

import com.ecoguia.ecoguia_api.api.model.UsuarioModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Restaurantes")
public interface EcopontoUsuarioResponsavelControllerOpenApi {

    @Operation(summary = "Lista os usuários responsáveis associados ao ecoponto", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "EcoPonto não encontrado",
                    content = {@Content(schema = @Schema(ref = "Problema")) }),
    })
    List<UsuarioModel> listar(
            @Parameter(description = "ID do ecoponto", example = "1", required = true) Long ecopontoId);

    @Operation(summary = "Associação de ecoponto com usuário responsável", responses = {
            @ApiResponse(responseCode = "204", description = "Associação realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ecoponto ou usuário não encontrado",
                    content = {@Content(schema = @Schema(ref = "Problema")) }),
    })
    ResponseEntity<Void> associar(
            @Parameter(description = "ID do ecoponto", example = "1", required = true) Long ecopontoId,
            @Parameter(description = "ID do usuário", example = "1", required = true) Long usuarioId);

    @Operation(summary = "Desassociação de ecoponto com usuário responsável", responses = {
            @ApiResponse(responseCode = "204", description = "Desassociação realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ecoponto ou usuário não encontrado",
                    content = {@Content(schema = @Schema(ref = "Problema")) }),
    })
    ResponseEntity<Void> desassociar(
            @Parameter(description = "ID do ecoponto", example = "1", required = true) Long ecopontoId,
            @Parameter(description = "ID do usuário", example = "1", required = true) Long usuarioId);

}
