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

    BigDecimal artLowLimitWholesale;

    BigDecimal artLowLimitSemiWholesale;

    BigDecimal artQuantityinstock;

    /************************************
     * Pointofsale owner of the Article
     */
    @Column(nullable = false)
    Long artPosId;

    /******************************
     * Relation between entities  *
     * ****************************/
    //Many article is associated to 1 ProductFormated
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pf_id", nullable = false, referencedColumnName = "id")
    ProductFormated artPf;
    //Many article must be related to 1 unit
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unit_id", nullable = false, referencedColumnName = "id")
    Unit artUnit;
    //Every article has one and only one BasePrice
    @OneToOne
    @JoinColumn(name = "bp_id", nullable = false, referencedColumnName = "id")
    Baseprice artBp;


    //Une liste d'arrivage pour un article
    @OneToMany(mappedBy = "aArticle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Arrival> arrivalList;

}
