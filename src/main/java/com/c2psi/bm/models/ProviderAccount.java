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
@Table(name="provider_account",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"provider_id", "art_id"}),
                @UniqueConstraint(
                        columnNames = {"provider_id", "packaging_id"})})
public class ProviderAccount extends AbstractEntity{
    /***************************************************************************************
     * Must always be positive or zero. The value represents the number of capsule that the
     * pointofsale has already sent to the corresponding provider.
     */
    BigDecimal providerNumberofCapsule;
    /**********************************************************************************************
     * Must always be positive or zero. The value represents the number of damage article that the
     * pointofsale must exchange with the corresponding article. And give to the client
     */
    BigDecimal providerNumberofDamage;

    /************************************************************************************************
     * Represents the number of packaging related to the client. If the value is negative that means
     * the client must return that number to the pointofsale and if the number is positive that means
     * the pointofsale should return that number to the client
     */
    BigDecimal providerNumberofPackaging;

    /******************************
     * Relation between entities  *
     * ****************************/
    //Sevaral line per client but one per article
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id", nullable = false, referencedColumnName = "id")
    Provider proaProvider;

    //Sevaral line per article but one per client
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "art_id", nullable = false, referencedColumnName = "id")
    Article proaArticle;

    //Sevaral line per packaging but one per client
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "packaging_id", nullable = false, referencedColumnName = "id")
    Packaging proaPackaging;
}
