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
@Table(name="packaging",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"packLabel", "packFirstcolor", "provider_id", "posPackagingId"})})
public class Packaging extends AbstractEntity{
    @Column(nullable = false)
    String packLabel;
    String packDescription;

    String packFirstcolor;

    BigDecimal packPrice;

    /****************************************************
     * The pointofsale in which the packaging is created
     */
    @Column(nullable = false)
    Long posPackagingId;

    /******************************
     * Relation between entities  *
     * ****************************/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id", nullable = false, referencedColumnName = "id")
    Provider packagingProvider;
}
