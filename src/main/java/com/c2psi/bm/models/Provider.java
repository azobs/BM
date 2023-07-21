package com.c2psi.bm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="provider",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"providerName", "posProviderId"})})
public class Provider extends AbstractEntity{
    @Column(nullable = false)
    String providerName;

    @Column(nullable = false)
    String providerAcronym;
    String providerDescription;
    @Embedded
    Address providerAddress;
    /***********************************
     * The pointofsale of the provider
     */
    @Column(nullable = false)
    Long posProviderId;

    /**************************************************************************************
     * Balance account of the provider. It represents the amount that the pointofsale must
     * return to the provider (if is negative) or vice versa (If it is positive)
     */
    BigDecimal providerBalance;

    /******************************
     * Relation between entities  *
     * ****************************/

}
