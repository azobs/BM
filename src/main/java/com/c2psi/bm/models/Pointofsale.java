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
@Table(name="pointofsale",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"posName", "ent_id"})})
public class Pointofsale extends AbstractEntity{
    @Column(nullable = false)
    String posName;

    String posAcronym;
    String posDescription;
    @Embedded
    Address posAddress;

    /************************************************************************************
     * Balance account of the Pointofsale. It represents the amount that the pos must
     * paid to client or provider (if is negative) or have (If it is positive)
     */
    BigDecimal posBalance;

    /******************************
     * Relation between entities  *
     * ****************************/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "currency_id", nullable = false, referencedColumnName = "id")
    Currency posCurrency;
    //Each pointofsale belongs to 1 enterprise
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ent_id", nullable = false, referencedColumnName = "id")
    Enterprise posEnterprise;
}
