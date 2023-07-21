package com.c2psi.bm.models;

import com.c2psi.bm.enumerations.RoleNature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="role")
public class Role extends AbstractEntity{
    @Column(unique = true)
    RoleNature roleName;
    String roleAlias;
    String roleDescription;

}
