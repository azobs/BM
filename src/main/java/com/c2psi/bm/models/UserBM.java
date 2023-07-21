package com.c2psi.bm.models;

import com.c2psi.bm.enumerations.UserBMState;
import com.c2psi.bm.enumerations.UserBMType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="userbm",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"bmName", "bmSurname", "bmDob"})})
public class UserBM extends AbstractEntity{
    @Column(nullable = false, unique = true)
    String bmLogin;

    @Column(nullable = false)
    String bmPassword;

    @Column(nullable = false)
    String bmName;

    String bmSurname;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    //@Temporal(TemporalType.DATE)
    Date bmDob;

    @Column(unique = true)
    String bmCni;
    String bmPicture;

    UserBMState bmUserState;

    UserBMType bmUsertype;//AdminBM, AdminEnterprise, Employe

    @Embedded
    Address bmAddress;

    Long posUserbmId;
    Long entUserbmId;
}
