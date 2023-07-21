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
@Table(name="pos_account",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"pos_id", "art_id"}),
                @UniqueConstraint(
                        columnNames = {"pos_id", "packaging_id"})})
public class PosAccount extends AbstractEntity{
    /***************************************************************************************
     * Must always be positive or zero. The value represents the number of capsule that the
     * pointofsale must exchange with the corresponding article.
     */
    BigDecimal paNumberofCapsule;
    /**********************************************************************************************
     * Must always be positive or zero. The value represents the number of damage article that the
     * pointofsale must exchange with the corresponding article.
     */
    BigDecimal paNumberofDamage;

    /**********************************************************************************************************
     * Represents the number of packaging related to the pos. If the value is negative that means
     * the pos must return that number to the corresponding provider and if the number is positive that means
     * the corresponding provider should return that number to the pointofsale
     */
    BigDecimal paNumberofPackaging;

    /******************************
     * Relation between entities  *
     * ****************************/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pos_id", nullable = false, referencedColumnName = "id")
    Pointofsale paPos;

    //Sevaral line per article but one per client
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "art_id", nullable = false, referencedColumnName = "id")
    Article paArticle;

    //Sevaral line per packaging but one per client
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "packaging_id", nullable = false, referencedColumnName = "id")
    Packaging paPackaging;
}
