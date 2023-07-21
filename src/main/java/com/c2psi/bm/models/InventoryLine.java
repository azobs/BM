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
@Table(name="inventory_line", uniqueConstraints = {@UniqueConstraint(
        columnNames = {"inv_id", "art_id"})})
public class InventoryLine extends AbstractEntity{
    String invlineComment;

    BigDecimal invlineRealqteinstock;

    BigDecimal invlineLogicqteinstock;

    /******************************
     * Relation between entities  *
     * ****************************/
    //L'inventaire dans lequel se trouve la ligne d'inventaire (InventoryLine)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inv_id", nullable = false, referencedColumnName = "id")
    Inventory invlineInv;

    //L'article pour lequel la ligne d'inventaire est ajoutee
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "art_id", nullable = false, referencedColumnName = "id")
    Article invlineArt;
}
