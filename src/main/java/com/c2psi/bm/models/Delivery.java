package com.c2psi.bm.models;

import com.c2psi.bm.enumerations.DeliveryState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="delivery",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"deliveryCode", "posDeliveryId"})})
public class Delivery extends AbstractEntity{
    /***********************************************
     * Le pointofsale auquel appartient le Delivery
     */
    @Column(nullable = false)
    Long posDeliveryId;

    @Column(nullable = false)
    String deliveryCode;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant deliveryDate;
    String deliveryComment;
    DeliveryState deliveryState;


    /******************************
     * Relation between entities  *
     * ****************************/
    //Le UserBM qui a saisi ou enregistre ou prepare la livraison et qui va saisir le rapport de la livraison
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userbm_id", nullable = false, referencedColumnName = "id")
    UserBM deliveryUserbm;

    //La liste des details de la livraison pour le controle des emballages
    @OneToMany(mappedBy = "ddDelivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<DeliveryDetails> deliveryDetailsList;

    //La liste des commandes qui constitue la livraison
    @OneToMany(mappedBy = "cmdDelivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Command> commandList;
}
