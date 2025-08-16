package com.ecoguia.ecoguia_api.domain.service;

import com.ecoguia.ecoguia_api.domain.exception.EcopontoNaoEncontradoException;
import com.ecoguia.ecoguia_api.domain.model.Cidade;
import com.ecoguia.ecoguia_api.domain.model.Ecoponto;
import com.ecoguia.ecoguia_api.domain.repository.EcopontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroEcopontoService {

    @Autowired
    private EcopontoRepository ecopontoRepository;

    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @Transactional
    public Ecoponto salvar(Ecoponto ecoponto) {
        Long cidadeId = ecoponto.getEndereco().getCidade().getId();
        Cidade cidade = cadastroCidadeService.buscarOuFalhar(cidadeId);

        ecoponto.getEndereco().setCidade(cidade);

        return ecopontoRepository.save(ecoponto);
    }

    @Transactional
    public void ativar(Long ecopontoId) {
        Ecoponto ecopontoAtual = buscarOuFalhar(ecopontoId);

        ecopontoAtual.ativar();
    }

    @Transactional
    public void inativar(Long ecopontoId) {
        Ecoponto ecopontoAtual = buscarOuFalhar(ecopontoId);

        ecopontoAtual.inativar();
    }

    @Transactional
    public void ativar(List<Long> ecopontoIds) {
        ecopontoIds.forEach(this::ativar);
    }

    @Transactional
    public void inativar(List<Long> ecopontoIds) {
        ecopontoIds.forEach(this::inativar);
    }

    @Transactional
    public void abrir(Long ecopontoId) {
        Ecoponto ecopontoAtual = buscarOuFalhar(ecopontoId);

        ecopontoAtual.abrir();
    }

    @Transactional
    public void fechar(Long ecopontoId) {
        Ecoponto ecopontoAtual = buscarOuFalhar(ecopontoId);

        ecopontoAtual.fechar();
    }

    public Ecoponto buscarOuFalhar(Long ecopontoId) {
        return ecopontoRepository.findById(ecopontoId)
                .orElseThrow(() -> new EcopontoNaoEncontradoException(ecopontoId));
    }
}
