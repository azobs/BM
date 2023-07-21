package com.c2psi.bm.models;

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
@Table(name="inventory",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"invCode", "posInvId"})})
public class Inventory extends AbstractEntity{
    String invComment;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant invDate;

    @Column(nullable = false)
    String invCode;
    @Column(nullable = false)
    Long posInvId;

    /******************************
     * Relation between entities  *
     ******************************/

    //La liste des lignes d'inventaire dans l'inventaire
    @OneToMany(mappedBy = "invlineInv", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<InventoryLine> inventoryLineList;
}
