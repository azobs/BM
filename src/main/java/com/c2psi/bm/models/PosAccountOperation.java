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
@Table(name="pos_account_operation")
public class PosAccountOperation extends AbstractEntity{
    @Embedded
    Operation paOperation;

    BigDecimal paNumberinmvt;

    /******************************
     * Relation between entities  *
     * ****************************/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "posaccount_id", nullable = false, referencedColumnName = "id")
    PosAccount paoPosAccount;
}
