package com.c2psi.bm.models;

import com.c2psi.bm.enumerations.ArrivalNature;
import com.c2psi.bm.enumerations.ArrivalType;
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
@Table(name="arrival", uniqueConstraints = {@UniqueConstraint(
        columnNames = {"art_id", "si_id"})})
public class Arrival extends AbstractEntity{
    @Column(nullable = false)
    BigDecimal deliveryQuantity;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant arrivalDate;
    BigDecimal arrivalUnitprice;
    ArrivalType arrivalType;
    ArrivalNature arrivalNature;

    /******************************
     * Relation between entities  *
     * ****************************/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "art_id", nullable = false, referencedColumnName = "id")
    Article aArticle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "si_id", nullable = false, referencedColumnName = "id")
    SupplyInvoice aSupplyInvoice;
}
