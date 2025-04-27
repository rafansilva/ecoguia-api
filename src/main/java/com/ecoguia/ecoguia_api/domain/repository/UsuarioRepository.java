package com.ecoguia.ecoguia_api.domain.repository;

import com.ecoguia.ecoguia_api.domain.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
