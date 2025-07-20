package org.lamisplus.modules.base.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "form_data")
public class FormData extends JsonBEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "data", nullable = false, columnDefinition = "jsonb")
    private Object data;

    @JoinColumn(name = "encounter_id")
    @ManyToOne
    private Encounter encounter;

    @Basic
    @Column(name = "date_modified")
    @JsonIgnore
    @UpdateTimestamp
    private Timestamp dateModified;

    @Basic
    @Column(name = "organisation_unit_id")
    @JsonIgnore
    private Long organisationUnitId;

    @ManyToOne
    @JoinColumn(name = "encounter_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Encounter encounterByEncounterId;

    @ManyToOne
    @JoinColumn(name = "organisation_unit_id", referencedColumnName = "id", insertable = false, updatable = false)
    public OrganisationUnit organisationUnitByOrganisationUnitId;
}
