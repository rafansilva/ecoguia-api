package com.ecoguia.ecoguia_api.domain.service;

import com.ecoguia.ecoguia_api.domain.exception.PermissaoNaoEncontradaException;
import com.ecoguia.ecoguia_api.domain.model.Permissao;
import com.ecoguia.ecoguia_api.domain.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public Permissao buscarOuFalhar(Long permissaoId) {
        return permissaoRepository.findById(permissaoId)
                .orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId));
    }

}
