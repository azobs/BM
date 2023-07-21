package com.c2psi.bm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="format",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"formatName", "formatCapacity", "posFormatId"})})
public class Format extends AbstractEntity{
    String formatName;

    BigDecimal formatCapacity;
    @Column(nullable = false)
    Long posFormatId;
    /******************************
     * Relation between entities  *
     * ****************************/
    //Each format belongs to 1 pointofsale


}
