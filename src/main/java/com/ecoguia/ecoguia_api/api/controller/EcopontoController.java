package com.ecoguia.ecoguia_api.api.controller;

import com.ecoguia.ecoguia_api.api.assembler.EcopontoApenasNomeModelAssembler;
import com.ecoguia.ecoguia_api.api.assembler.EcopontoBasicoModelAssembler;
import com.ecoguia.ecoguia_api.api.assembler.EcopontoInputDissambler;
import com.ecoguia.ecoguia_api.api.assembler.EcopontoModelAssembler;
import com.ecoguia.ecoguia_api.api.model.EcopontoApenasNomeModel;
import com.ecoguia.ecoguia_api.api.model.EcopontoBasicoModel;
import com.ecoguia.ecoguia_api.api.model.EcopontoModel;
import com.ecoguia.ecoguia_api.api.model.input.EcopontoInput;
import com.ecoguia.ecoguia_api.api.openapi.controller.EcopontoControllerOpenApi;
import com.ecoguia.ecoguia_api.core.security.CheckSecurity;
import com.ecoguia.ecoguia_api.domain.exception.CidadeNaoEncontradaException;
import com.ecoguia.ecoguia_api.domain.exception.EcopontoNaoEncontradoException;
import com.ecoguia.ecoguia_api.domain.exception.NegocioException;
import com.ecoguia.ecoguia_api.domain.model.Ecoponto;
import com.ecoguia.ecoguia_api.domain.repository.EcopontoRepository;
import com.ecoguia.ecoguia_api.domain.service.CadastroEcopontoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ecoponto", produces = MediaType.APPLICATION_JSON_VALUE)
public class EcopontoController implements EcopontoControllerOpenApi {

    @Autowired
    private EcopontoRepository ecopontoRepository;

    @Autowired
    private CadastroEcopontoService cadastroEcopontoService;

    @Autowired
    private EcopontoModelAssembler ecopontoModelAssembler;

    @Autowired
    private EcopontoBasicoModelAssembler ecopontoBasicoModelAssembler;

    @Autowired
    private EcopontoApenasNomeModelAssembler ecopontoApenasNomeModelAssembler;

    @Autowired
    private EcopontoInputDissambler ecopontoInputDissambler;

    @CheckSecurity.Ecopontos.PodeConsultar
    @Override
    @GetMapping
    public List<EcopontoBasicoModel> listar() {
        return ecopontoBasicoModelAssembler.toCollectionModel(ecopontoRepository.findAll());
    }

    @CheckSecurity.Ecopontos.PodeConsultar
    @Override
    @GetMapping(params = "projecao=apenas-nome")
    public List<EcopontoApenasNomeModel> listarApenasNomes() {
        return ecopontoApenasNomeModelAssembler
                .toCollectionModel(ecopontoRepository.findAll());
    }

    @CheckSecurity.Ecopontos.PodeConsultar
    @Override
    @GetMapping("/{ecopontoId}")
    public EcopontoModel buscar(@PathVariable Long ecopontoId) {
        Ecoponto ecoponto = cadastroEcopontoService.buscarOuFalhar(ecopontoId);

        return ecopontoModelAssembler.toModel(ecoponto);
    }

    @CheckSecurity.Ecopontos.PodeGerenciarCadastro
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EcopontoModel adicionar(@RequestBody @Valid EcopontoInput ecopontoInput) {
        try {
            Ecoponto ecoponto = ecopontoInputDissambler.toDomainObject(ecopontoInput);

            return ecopontoModelAssembler.toModel(cadastroEcopontoService.salvar(ecoponto));
        } catch (CidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @CheckSecurity.Ecopontos.PodeGerenciarCadastro
    @Override
    @PutMapping("/{ecopontoId}")
    public EcopontoModel atualizar(@PathVariable Long ecopontoId, @RequestBody @Valid EcopontoInput ecopontoInput) {
        try {
            Ecoponto ecopontoAtual = cadastroEcopontoService.buscarOuFalhar(ecopontoId);

            ecopontoInputDissambler.copyToDomainObject(ecopontoInput, ecopontoAtual);

            return ecopontoModelAssembler.toModel(cadastroEcopontoService.salvar(ecopontoAtual));
        } catch (CidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @CheckSecurity.Ecopontos.PodeGerenciarCadastro
    @Override
    @PutMapping("/{ecopontoId}/ativar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> ativar(Long ecopontoId) {
        cadastroEcopontoService.ativar(ecopontoId);

        return ResponseEntity.noContent().build();
    }

    @CheckSecurity.Ecopontos.PodeGerenciarCadastro
    @Override
    @DeleteMapping("/{ecopontoId}/inativar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> inativar(Long ecopontoId) {
        cadastroEcopontoService.inativar(ecopontoId);

        return ResponseEntity.noContent().build();
    }

    @CheckSecurity.Ecopontos.PodeGerenciarCadastro
    @Override
    @PutMapping("/ativacoes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> ativarMultiplos(List<Long> ecopontoIds) {
        try {
            cadastroEcopontoService.ativar(ecopontoIds);
            return ResponseEntity.noContent().build();
        } catch (EcopontoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @CheckSecurity.Ecopontos.PodeGerenciarCadastro
    @Override
    @DeleteMapping("/ativacoes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> inativarMultiplos(List<Long> ecopontoIds) {
        try {
            cadastroEcopontoService.inativar(ecopontoIds);
            return ResponseEntity.noContent().build();
        } catch (EcopontoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @CheckSecurity.Ecopontos.PodeGerenciarFuncionamento
    @Override
    @PutMapping("/{ecopontoId}/abertura")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> abrir(Long ecopontoId) {
        cadastroEcopontoService.abrir(ecopontoId);

        return ResponseEntity.noContent().build();
    }

    @CheckSecurity.Ecopontos.PodeGerenciarFuncionamento
    @Override
    @PutMapping("/{ecopontoId}/fechamento")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> fechar(Long ecopontoId) {
        cadastroEcopontoService.fechar(ecopontoId);

        return ResponseEntity.noContent().build();
    }
}
