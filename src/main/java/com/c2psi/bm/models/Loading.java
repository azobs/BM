package com.c2psi.bm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="loading",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"loadCode", "posLoadId"})})
public class Loading extends AbstractEntity{
    /*********************************************
     * The pointofsale owner of the Loading
     */
    @Column(nullable = false)
    Long posLoadId;
    @Column(nullable = false)
    String loadCode;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant loadDate;

    //LoadingState loadState;

    BigDecimal loadTotalamountexpected;

    BigDecimal loadTotalamountpaid;

    BigDecimal loadRemise;
    //Where we can add an explanation of what happens during the saling session
    String loadSalereport;
    String loadComment;

    /******************************
     * Relation between entities  *
     * ****************************/
    //Le Userbm qui a enregistre le chargement
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userbm_manager_id", nullable = false, referencedColumnName = "id")
    UserBM loadUserbmManager;

    //Le Userbm pour lequel le chargement est enregistre
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userbm_saler_id", nullable = false, referencedColumnName = "id")
    UserBM loadUserbmSaler;
}
