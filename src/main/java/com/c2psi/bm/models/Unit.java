package com.c2psi.bm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="unit",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"unitName", "posUnitId"})})
public class Unit extends AbstractEntity{
    /*******************************************
     * The pointofsale owner of the Unit
     */
    @Column(nullable = false)
    Long posUnitId;
    /****
     * This Unit represent what we call conditionnement: Bouteille, quart de casier, tier de casier,
     * Demi casier, trois quart de casier, casier, etc.
     */
    @Column(nullable = false)
    String unitName;
    String unitAbbreviation;
}
