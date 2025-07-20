package org.lamisplus.modules.base.repository;

import org.lamisplus.modules.base.domain.entity.RegimenLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegimenLineRepository extends JpaRepository<RegimenLine, Long> {
    Optional<RegimenLine> getRegimenLineById(Long id);
}
