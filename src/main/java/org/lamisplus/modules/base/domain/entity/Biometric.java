package org.lamisplus.modules.base.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.lamisplus.modules.base.util.converter.LocalDateConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "biometric")
public class Biometric implements Serializable  {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_enrollment")
    @Convert(converter = LocalDateConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateEnrollment;

    @Basic
    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Basic
    @Column(name = "biometric_type")
    private String biometricType;

    @Basic
    @Column(name = "template")
    private byte[] template;

}
