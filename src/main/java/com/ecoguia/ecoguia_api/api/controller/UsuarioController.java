package com.ecoguia.ecoguia_api.api.controller;

import com.ecoguia.ecoguia_api.api.assembler.UsuarioInputDisassembler;
import com.ecoguia.ecoguia_api.api.assembler.UsuarioModelAssembler;
import com.ecoguia.ecoguia_api.api.model.UsuarioModel;
import com.ecoguia.ecoguia_api.api.model.input.SenhaInput;
import com.ecoguia.ecoguia_api.api.model.input.UsuarioComSenhaInput;
import com.ecoguia.ecoguia_api.api.model.input.UsuarioInput;
import com.ecoguia.ecoguia_api.api.openapi.controller.UsuarioControllerOpenApi;
import com.ecoguia.ecoguia_api.domain.model.Usuario;
import com.ecoguia.ecoguia_api.domain.repository.UsuarioRepository;
import com.ecoguia.ecoguia_api.domain.service.CadastroUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController implements UsuarioControllerOpenApi {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @Autowired
    private UsuarioInputDisassembler usuarioInputDisassembler;

    @Override
    @GetMapping
    public List<UsuarioModel> listar() {
        List<Usuario> todasUsuarios = usuarioRepository.findAll();

        return usuarioModelAssembler.toCollectionModel(todasUsuarios);
    }

    @Override
    @GetMapping("/{usuarioId}")
    public UsuarioModel buscar(@PathVariable Long usuarioId) {
        Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);

        return usuarioModelAssembler.toModel(usuario);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioInput) {
        Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioInput);
        usuario = cadastroUsuario.salvar(usuario);

        return usuarioModelAssembler.toModel(usuario);
    }

    @Override
    @PutMapping("/{usuarioId}")
    public UsuarioModel atualizar(@PathVariable Long usuarioId,
                                  @RequestBody @Valid UsuarioInput usuarioInput) {
        Usuario usuarioAtual = cadastroUsuario.buscarOuFalhar(usuarioId);
        usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarioAtual);
        usuarioAtual = cadastroUsuario.salvar(usuarioAtual);

        return usuarioModelAssembler.toModel(usuarioAtual);
    }

    @Override
    @PutMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> alterarSenha(@PathVariable Long usuarioId, @RequestBody @Valid SenhaInput senha) {
        cadastroUsuario.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
        return ResponseEntity.noContent().build();
    }

}