package com.c2psi.bm.services.contract.pos.userbm;

import com.c2psi.bm.dtos.pos.userbm.UserBMDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserBMService {
    UserBMDto saveUserBM(UserBMDto dto);
    UserBMDto updateUserBM(UserBMDto dto);
    Boolean deleteUserBMById(Long id);
    List<UserBMDto> findAllUserBM(String keyword);
    Page<UserBMDto> findPageUserBM(String keyword, int pagenum, int pagesize);
}
