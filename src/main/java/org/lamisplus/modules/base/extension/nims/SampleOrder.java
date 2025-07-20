package org.lamisplus.modules.base.extension.nims;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.lamisplus.modules.base.domain.entity.JsonBEntity;
import org.lamisplus.modules.base.domain.entity.OrganisationUnit;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "sample_order")
public class SampleOrder extends JsonBEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*
    @Column(name = "order_id")
    private String orderId;
*/

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "details", nullable = false, columnDefinition = "jsonb")
    private Object details;

/*
    @Column(name = "location")
    private String location;

    @Column(name = "info")
    private String info;
 */

    @ManyToOne
    @JoinColumn(name = "organisation_unit_id")
    @NotNull
    private OrganisationUnit organisationUnit;

    @Column(name = "dispatched")
    private Boolean dispatched;
}
