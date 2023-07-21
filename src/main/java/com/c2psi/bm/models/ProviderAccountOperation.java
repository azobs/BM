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
@Table(name="provider_account_operation")
public class ProviderAccountOperation extends AbstractEntity{
    @Embedded
    Operation paoOperation;

    BigDecimal paoNumberinmvt;
    /******************************
     * Relation between entities  *
     * ****************************/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provideraccount_id", nullable = false, referencedColumnName = "id")
    ProviderAccount paoProviderAccount;
}
