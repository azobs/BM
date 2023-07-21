package com.c2psi.bm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="product",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"prodCode", "posProdId"})})
public class Product extends AbstractEntity{
    /**************************************
     * Pointofsale of the product
     */
    @Column(nullable = false)
    Long posProdId;
    @Column(nullable = false)
    String prodCode;
    String prodName;
    String prodDescription;
    String prodAlias;
    Boolean prodPerishable;

    /******************************
     * Relation between entities  *
     * ****************************/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cat_id", nullable = false, referencedColumnName = "id")
    Category prodCat;//sabc, ucb, guiness, biere, jus, eau, gaz

}
