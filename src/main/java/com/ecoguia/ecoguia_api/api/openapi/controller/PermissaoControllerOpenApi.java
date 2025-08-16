package com.ecoguia.ecoguia_api.api.openapi.controller;

import com.ecoguia.ecoguia_api.api.model.PermissaoModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Permissões")
public interface PermissaoControllerOpenApi {

    @Operation(summary = "Lista as permissões")
    List<PermissaoModel> listar();

}