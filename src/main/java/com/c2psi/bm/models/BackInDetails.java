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
@Table(name="backindetails",
        uniqueConstraints = {@UniqueConstraint(
            columnNames = {"art_id", "bi_id"})})
public class BackInDetails extends AbstractEntity{
    BigDecimal bidQuantity;
    String bidComment;

    /******************************
     * Relation between entities  *
     * ****************************/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "art_id", nullable = false, referencedColumnName = "id")
    Article bidArticle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bi_id", nullable = false, referencedColumnName = "id")
    BackIn bidbi;
}
