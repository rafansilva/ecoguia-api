package com.ecoguia.ecoguia_api.api.controller;

import com.ecoguia.ecoguia_api.api.assembler.PermissaoModelAssembler;
import com.ecoguia.ecoguia_api.api.model.PermissaoModel;
import com.ecoguia.ecoguia_api.api.openapi.controller.PermissaoControllerOpenApi;
import com.ecoguia.ecoguia_api.core.security.CheckSecurity;
import com.ecoguia.ecoguia_api.domain.model.Permissao;
import com.ecoguia.ecoguia_api.domain.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/permissoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class PermissaoController implements PermissaoControllerOpenApi {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private PermissaoModelAssembler permissaoModelAssembler;

    @CheckSecurity.UsuariosGruposPermissoes.PodeConsultar
    @Override
    @GetMapping
    public List<PermissaoModel> listar() {
        List<Permissao> todasPermissoes = permissaoRepository.findAll();

        return permissaoModelAssembler.toCollectionModel(todasPermissoes);
    }

}
