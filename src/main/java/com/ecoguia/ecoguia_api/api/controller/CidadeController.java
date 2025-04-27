package com.ecoguia.ecoguia_api.api.controller;

import com.ecoguia.ecoguia_api.api.assembler.CidadeInputDisassembler;
import com.ecoguia.ecoguia_api.api.assembler.CidadeModelAssembler;
import com.ecoguia.ecoguia_api.api.model.CidadeModel;
import com.ecoguia.ecoguia_api.api.model.input.CidadeInput;
import com.ecoguia.ecoguia_api.api.openapi.controller.CidadeControllerOpenApi;
import com.ecoguia.ecoguia_api.domain.exception.EstadoNaoEncontradoException;
import com.ecoguia.ecoguia_api.domain.exception.NegocioException;
import com.ecoguia.ecoguia_api.domain.model.Cidade;
import com.ecoguia.ecoguia_api.domain.repository.CidadeRepository;
import com.ecoguia.ecoguia_api.domain.service.CadastroCidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
public class CidadeController implements CidadeControllerOpenApi {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidade;

    @Autowired
    private CidadeModelAssembler cidadeModelAssembler;

    @Autowired
    private CidadeInputDisassembler cidadeInputDisassembler;

    @Override
    @GetMapping
    public List<CidadeModel> listar() {
        List<Cidade> todasCidades = cidadeRepository.findAll();

        return cidadeModelAssembler.toCollectionModel(todasCidades);
    }

    @Override
    @GetMapping("/{cidadeId}")
    public CidadeModel buscar(@PathVariable Long cidadeId) {
        Cidade cidade = cadastroCidade.buscarOuFalhar(cidadeId);

        return cidadeModelAssembler.toModel(cidade);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeModel adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
        try {
            Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);

            cidade = cadastroCidade.salvar(cidade);

            return cidadeModelAssembler.toModel(cidade);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    @PutMapping("/{cidadeId}")
    public CidadeModel atualizar(@PathVariable Long cidadeId,
                                 @RequestBody @Valid CidadeInput cidadeInput) {
        try {
            Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);

            cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeAtual);

            cidadeAtual = cadastroCidade.salvar(cidadeAtual);

            return cidadeModelAssembler.toModel(cidadeAtual);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @Override
    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> remover(@PathVariable Long cidadeId) {
        cadastroCidade.excluir(cidadeId);
        return ResponseEntity.noContent().build();
    }

}