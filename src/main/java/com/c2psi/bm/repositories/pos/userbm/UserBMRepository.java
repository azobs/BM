package com.c2psi.bm.repositories.pos.userbm;

import com.c2psi.bm.models.UserBM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface UserBMRepository extends JpaRepository<UserBM, Long> {
    Optional<UserBM> findUserBMById(Long id);
    @Query("SELECT ub FROM UserBM  ub WHERE ub.bmLogin=:login")
    Optional<UserBM> findUserBMByLogin(@Param("login") String login);
    @Query("SELECT ub FROM UserBM  ub WHERE ub.bmCni=:cni")
    Optional<UserBM> findUserBMByCni(@Param("cni") String cni);
    @Query("SELECT ub FROM UserBM  ub WHERE ub.bmAddress.email=:email")
    Optional<UserBM> findUserBMByEmail(@Param("email") String email);
    @Query("SELECT ub FROM UserBM  ub WHERE ub.bmName=:name AND ub.bmSurname=:surname AND ub.bmDob BETWEEN :dob AND :dob")
    Optional<UserBM> findUserBMByFullname(@Param("name") String name, @Param("surname") String surname, @Param("dob") Date dob);
}
