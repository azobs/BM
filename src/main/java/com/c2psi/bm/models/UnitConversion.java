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
@Table(name="unit_conversion",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"unit_source_id", "unit_destination_id"})})
public class UnitConversion extends AbstractEntity{
    BigDecimal conversionFactor;
    /******************************
     * Relation between entities  *
     * ****************************/
    //Many unitconversion for 1 unit source
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unit_source_id", nullable = false, referencedColumnName = "id")
    Unit unitSource;
    //Many unitconversion for 1 unit destination
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unit_destination_id", nullable = false, referencedColumnName = "id")
    Unit unitDestination;
}
