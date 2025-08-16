package com.ecoguia.ecoguia_api.domain.repository;

import com.ecoguia.ecoguia_api.domain.model.Ecoponto;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EcopontoRepository extends CustomJpaRepository<Ecoponto, Long>, JpaSpecificationExecutor<Ecoponto> {

    @Query("SELECT COUNT(e) > 0 FROM Ecoponto e JOIN e.responsaveis r " +
            "WHERE e.id = :ecopontoId AND r.id = :usuarioId")
    Boolean existsResponsavel(@Param("ecopontoId") Long ecopontoId,
                              @Param("usuarioId") Long usuarioId);
}
