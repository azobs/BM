package com.c2psi.bm.models;

import com.c2psi.bm.enumerations.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="supply_invoice",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"siCode", "posSiId"})})
public class SupplyInvoice extends AbstractEntity{
    /*********************************************
     * The pointofsale owner of the SupplyInvoice
     */
    @Column(nullable = false)
    Long posSiId;
    @Column(nullable = false)
    String siCode;
    String siComment;
    String siPicture;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant siDeliverydate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant siInvoicingdate;

    BigDecimal siTotalcolis;
    /********************************************************************************
     * Montant de la facture d'approvisionnement ou alors nombre d'article attendu
     * dans le cas ou c'est une facture de changement de capsule ou d'avarie
     */
    BigDecimal siAmountOrNumberExpected;
    /***********************************************************************************
     * Montant effectivement verse pour la facture ou alors nombre d'article exactement
     * livre dans le point de vente dans le cas ou c'est une facture de changement de
     * capsule ou d'avarie
     */
    BigDecimal siAmountOrNumberPaid;
    PaymentMethod siPaymentmethod;

    /******************************
     * Relation between entities  *
     * ****************************/
    //Une liste d'arrivage pour un article
    @OneToMany(mappedBy = "aSupplyInvoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Arrival> arrivalList;

}
