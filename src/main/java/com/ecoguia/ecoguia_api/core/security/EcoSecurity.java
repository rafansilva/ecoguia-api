package com.ecoguia.ecoguia_api.core.security;

import com.ecoguia.ecoguia_api.domain.repository.EcopontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class EcoSecurity {

    @Autowired
    private EcopontoRepository ecopontoRepository;

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public boolean isAutenticado() {
        return getAuthentication().isAuthenticated();
    }

    public Long getUsuarioId() {
        Jwt jwt = (Jwt) getAuthentication().getPrincipal();

        Object usuarioId = jwt.getClaim("usuario_id");

        if (usuarioId == null) {
            return null;
        }
        return Long.valueOf(usuarioId.toString());
    }

    public boolean gerenciaEcoponto(Long ecopontoId) {
        if (ecopontoId == null) {
            return false;
        }

        return ecopontoRepository.existsResponsavel(ecopontoId, getUsuarioId());
    }

    public boolean usuarioAutenticadoIgual(Long usuarioId) {
        return getUsuarioId() != null && usuarioId != null
                && getUsuarioId().equals(usuarioId);
    }

    public boolean hasAuthority(String authorityName) {
        return getAuthentication().getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(authorityName));
    }

    public boolean temEscopoEscrita() {
        return hasAuthority("SCOPE_WRITE");
    }

    public boolean temEscopoLeitura() {
        return hasAuthority("SCOPE_READ");
    }

    public boolean podeConsultarUsuariosGruposPermissoes() {
        return temEscopoLeitura() && hasAuthority("CONSULTAR_USUARIOS_GRUPOS_PERMISSOES");
    }

    public boolean podeEditarUsuariosGruposPermissoes() {
        return temEscopoEscrita() && hasAuthority("EDITAR_USUARIOS_GRUPOS_PERMISSOES");
    }

    public boolean podeConsultarCidades() {
        return isAutenticado() && temEscopoLeitura();
    }

    public boolean podeConsultarEstados() {
        return isAutenticado() && temEscopoLeitura();
    }


    public boolean podeConsultarEcopontos() {
        return temEscopoLeitura() && isAutenticado();
    }

    public boolean podeGerenciarCadastroEcopontos() {
        return temEscopoEscrita() && hasAuthority("EDITAR_ECOPONTOS");
    }

    public boolean podeGerenciarFuncionamentoEcopontos(Long ecopontoId) {
        return temEscopoEscrita() && (hasAuthority("EDITAR_ECOPONTOS")
                || gerenciaEcoponto(ecopontoId)
                );
    }
}
