package org.lamisplus.modules.base.repository;

import org.lamisplus.modules.base.domain.entity.Encounter;
import org.lamisplus.modules.base.domain.entity.FormData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FormDataRepository extends JpaRepository<FormData, Long>, JpaSpecificationExecutor {
    Optional<FormData> findByIdAndOrganisationUnitId(Long id, Long organisationUnitId);

    List<FormData> findAllByOrganisationUnitId(Long organisationUnitId);

    List<FormData> findByEncounter(Encounter encounter);

    @Query(value = "select d from FormData d where d.encounter.id = (select distinct e.id from Encounter e where e.dateEncounter = ?1 and e.patientId = ?2)")
    List<FormData> findByDateEncounterAndPatientId(LocalDate dateEncounter, Long patientId);

    @Query(value = "select d from FormData d where d.encounter.id in (select e.id from Encounter e where e.formCode = ?1 and e.patientId = ?2)")
    List<FormData> findByFormCodeAndPatientId(String formCode, Long patientId);

}
