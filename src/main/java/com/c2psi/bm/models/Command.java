package com.c2psi.bm.models;

import com.c2psi.bm.enumerations.CommandNature;
import com.c2psi.bm.enumerations.CommandState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="command",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"cmdCode", "posCmdId"})})
public class Command extends AbstractEntity{
    /***********************************************
     * Le pointofsale auquel appartient la command
     */
    @Column(nullable = false)
    Long posCmdId;
    @Column(nullable = false)
    String cmdCode;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant cmdDate;
    String cmdComment;

    CommandState cmdState;//InEditing, Edited, PackupUp

    CommandNature cmdNature;//Cash, Capsule, Damage

    /******************************
     * Relation between entities  *
     * ****************************/
    //Une command est livre dans un bon de livraison mais a la creation le Delivery n'est pas encore enregistre
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id",  referencedColumnName = "id")
    Delivery cmdDelivery;

    //Une command peut etre effectue dans un chargement (Loading)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loading_id", referencedColumnName = "id")
    Loading cmdLoading;

    //Le client proprietaire de la command
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client cmdClient;

    //L'utilisateur qui a enregistre la command
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userbm_id", nullable = false, referencedColumnName = "id")
    UserBM cmdUserbm;

    //La facture associe a la commande
    //02 command ne peuvent avoir la meme facture donc ce champ quand il existe doit etre unique
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saleicash_id",  referencedColumnName = "id")
    SaleInvoice cmdSaleinvoice;

}
