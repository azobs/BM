package com.c2psi.bm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="packing_details",uniqueConstraints = {@UniqueConstraint(
        columnNames = {"packaging_id", "loading_id"})})
public class PackagingDetails extends AbstractEntity{
    BigDecimal pdNumberofpackageused;

    BigDecimal pdNumberofpackagereturn;

    /******************************
     * Relation between entities  *
     * ****************************/
    //Le packaging associe a ce details de packaging
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "packaging_id", nullable = false, referencedColumnName = "id")
    Packaging pdPackaging;

    //Le chargement associe a ce details de packaging
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loading_id", nullable = false, referencedColumnName = "id")
    Loading pdLoading;
}
