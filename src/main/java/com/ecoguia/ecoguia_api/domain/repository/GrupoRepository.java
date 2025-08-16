package com.ecoguia.ecoguia_api.domain.repository;

import com.ecoguia.ecoguia_api.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}