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
@Table(name="client_account_operation")
public class ClientAccountOperation extends AbstractEntity{
    @Embedded
    Operation caoOperation;

    BigDecimal caoNumberinmvt;
    /******************************
     * Relation between entities  *
     * ****************************/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clientaccount_id", nullable = false, referencedColumnName = "id")
    ClientAccount caoClientAccount;
}
