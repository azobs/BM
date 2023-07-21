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
@Table(name="client",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"clientName", "clientOthername", "posClientId"}),
                @UniqueConstraint(
                        columnNames = {"clientCni", "posClientId"})})
public class Client extends AbstractEntity{
    @Column(nullable = false)
    String clientName;
    String clientOthername;
    String clientCni;
    @Embedded
    Address clientAddress;
    /************************************
     * Pointofsale owner of the client
     */
    @Column(nullable = false)
    Long posClientId;
    /*******************************************************************************
     * Balance account of the client. It represents the amount that the client must
     * return to the pointofsale (if is negative) or vice versa (If it is positive)
     */
    BigDecimal clientBalance;

    /******************************
     * Relation between entities  *
     * ****************************/
    //Une liste de comptes client pour un client. Un compte par article
    @OneToMany(mappedBy = "ccClient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ClientAccount> clientAccountList;
}
