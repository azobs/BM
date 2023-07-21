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
@Table(name="article",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"artCode", "artPosId"})})
public class Test extends AbstractEntity{
    @Column(nullable = false)
    String artCode;

    @Column(nullable = false)
    String artName;

    @Column(nullable = false)
    String artShortname;
    String artDescription;

    BigDecimal artThreshold;

    BigDecimal artLowLimitWholesale;

    BigDecimal artLowLimitSemiWholesale;

    BigDecimal artQuantityinstock;

    /************************************
     * Pointofsale owner of the Article
     */
    @Column(nullable = false)
    Long artPosId;
}
