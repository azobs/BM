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
@Table(name="article",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"artCode", "artPosId"})})
public class Article extends AbstractEntity {

    @Column(nullable = false)
    String artCode;

    @Column(nullable = false)
    String artName;

    @Column(nullable = false)
    String artShortname;
    String artDescription;

    BigDecimal artThreshold;

    /*****
     * A negative value means there the article cannot be selling in whole
     */
    BigDecimal artLowLimitWholesale;

    /*****
     * A negative value means there the article cannot be selling in semi-whole
     */
    BigDecimal artLowLimitSemiWholesale;

    BigDecimal artQuantityinstock;

    Long artPosId;

}
