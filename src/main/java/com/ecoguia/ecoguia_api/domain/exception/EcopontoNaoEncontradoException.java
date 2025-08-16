package com.ecoguia.ecoguia_api.domain.exception;

public class EcopontoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public EcopontoNaoEncontradoException(String message) {
        super(message);
    }

    public EcopontoNaoEncontradoException(Long ecopontoId) {
        this(String.format("Não existe um cadastro de ecoponto com código %d", ecopontoId));
    }
}
