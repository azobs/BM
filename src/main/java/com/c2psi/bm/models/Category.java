package com.c2psi.bm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="category",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"catCode", "posCatId"})})
public class Category extends AbstractEntity{
    @Column(nullable = false)
    String catName;
    String catShortname;

    @Column(nullable = false)
    String catCode;
    String catDescription;

    /************************************
     * Pointofsale owner of the category
     */
    @Column(nullable = false)
    Long posCatId;
    Long catParentId;


    /******************************
     * Relation between entities  *
     * ****************************/


    /*********************************************************
     * Example of category according to that project
     * BIERRE, JUS, EAU, GAZ
     *      SUB CATEGORY
     *          SABC, UCB, BRAZAF, GUINNESS, SCTM
     ********************************************************/
}
