package com.c2psi.bm.services.contractImpl.pos.pos;

import com.c2psi.bm.dtos.pos.pos.EnterpriseDto;
import com.c2psi.bm.repositories.pos.pos.EnterpriseRepository;
import com.c2psi.bm.repositories.pos.userbm.UserBMRepository;
import com.c2psi.bm.services.contract.pos.pos.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public class EnterpriseServiceImpl implements EnterpriseService {
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public EnterpriseDto saveEnterprise(EnterpriseDto dto) {
        /*****************************************************
         * Il faut valider le dto recuperer
         */

        /***********************************************
         * Il faut verifier que le Niu utilise et le
         * name seront unique en BD
         */

        /**************************************************
         * On verifie que l'administrateur precise existe
         * vraiment en BD
         */

        /****************************************************
         * On effectue donc l'enregistrement proprement dit
         */
        return null;
    }

    @Override
    public EnterpriseDto updateEnterprise(EnterpriseDto dto) {
        return null;
    }

    @Override
    public EnterpriseDto findEnterpriseById(Long id) {
        return null;
    }

    @Override
    public Boolean deleteEnterpriseById(Long id) {
        return null;
    }

    @Override
    public List<EnterpriseDto> findAllEnterprise(String keyword) {
        return null;
    }

    @Override
    public Page<EnterpriseDto> findPageEnterprise(String keyword, int pagenum, int pagesize) {
        return null;
    }
}
