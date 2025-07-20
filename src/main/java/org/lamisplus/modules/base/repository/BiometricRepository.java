package org.lamisplus.modules.base.repository;

import org.lamisplus.modules.base.domain.entity.Appointment;
import org.lamisplus.modules.base.domain.entity.Biometric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BiometricRepository extends JpaRepository<Biometric, Long> {
    List<Biometric> findAllByPatientId (Long patientId);
}
