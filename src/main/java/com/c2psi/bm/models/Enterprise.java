package com.c2psi.bm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="enterprise")
public class Enterprise extends AbstractEntity{
    String entRegime;

    String entSocialreason;

    String entDescription;

    @Column(nullable = false, unique = true)
    String entNiu;//Numéro d'identification unique

    @Column(nullable = false, unique = true)
    String entName;

    String entAcronym;
    String entLogo;
    @Embedded
    Address entAddress;

    /******************************
     * Relation between entities  *
     * ****************************/
    //Each enterprise must be manage by 1 userBM
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userbm_id", nullable = false, referencedColumnName = "id")
    UserBM entAdmin;
}
