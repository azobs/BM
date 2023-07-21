package com.c2psi.bm.services.contract.pos.pos;

import com.c2psi.bm.dtos.pos.pos.EnterpriseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EnterpriseService {
    EnterpriseDto saveEnterprise(EnterpriseDto dto);
    EnterpriseDto updateEnterprise(EnterpriseDto dto);
    EnterpriseDto findEnterpriseById(Long id);
    Boolean deleteEnterpriseById(Long id);
    List<EnterpriseDto> findAllEnterprise(String keyword);
    Page<EnterpriseDto> findPageEnterprise(String keyword, int pagenum, int pagesize);
}
