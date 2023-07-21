package com.c2psi.bm.models;

import com.c2psi.bm.enumerations.SaleType;
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
@Table(name="sale")
public class Sale extends AbstractEntity{
    BigDecimal saleQuantity;
    String saleComment;
    BigDecimal saleFinalprice;

    SaleType saleType;
    @Column(nullable = false)
    Long posSaleId;

    /******************************
     * Relation between entities  *
     * ****************************/
    //Une vente (sale) figure toujours dans une commande
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "command_id", nullable = false, referencedColumnName = "id")
    Command saleCommand;

    //Une vente concerne toujours un Article
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "art_id", nullable = false, referencedColumnName = "id")
    Article saleArticle;

}

