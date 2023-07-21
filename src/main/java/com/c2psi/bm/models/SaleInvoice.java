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
@Table(name="sale_invoice",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"siCode", "posSiId"})})
public class SaleInvoice extends AbstractEntity{
    /*********************************************
     * The pointofsale owner of the SupplyInvoice
     */
    @Column(nullable = false)
    Long posSiId;

    @Column(nullable = false)
    String siCode;
    String siComment;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant siDeliverydate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant siInvoicingdate;

    @Column(nullable = false)
    BigDecimal siTotalcolis;

    /********************************************************************************
     * Montant de la facture vente ou alors nombre d'article a livre
     * dans le cas ou c'est une facture de changement de capsule ou d'avarie
     */
    @Column(nullable = false)
    BigDecimal siAmountOrNumberToDelivery;
    /***********************************************************************************
     * Montant effectivement verse pour la facture ou alors nombre d'article exactement
     * livre chez le client dans le cas ou c'est une facture de changement de
     * capsule ou d'avarie
     */
    @Column(nullable = false)
    BigDecimal siAmountOrNumberPaid;
    @Column(nullable = false)
    PaymentMethod siPaymentmethod;

    /******************************
     * Relation between entities  *
     * ****************************/

}
