package com.c2psi.bm.services.contractImpl.pos.userbm;

import com.c2psi.bm.dtos.pos.userbm.UserBMDto;
import com.c2psi.bm.enumerations.ErrorCode;
import com.c2psi.bm.enumerations.UserBMType;
import com.c2psi.bm.exceptions.DuplicateEntityException;
import com.c2psi.bm.exceptions.InvalidEntityException;
import com.c2psi.bm.models.UserBM;
import com.c2psi.bm.repositories.pos.userbm.UserBMRepository;
import com.c2psi.bm.services.contract.pos.userbm.UserBMService;
import com.c2psi.bm.validators.pos.Userbm.UserBMDtoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service(value="UserBMServiceV1")
@Slf4j
@Transactional
public class UserBMServiceImpl implements UserBMService {
    private UserBMRepository userBMRepository;

    @Autowired
    public UserBMServiceImpl(UserBMRepository userBMRepository) {
        this.userBMRepository = userBMRepository;
    }

    @Override
    public UserBMDto saveUserBM(UserBMDto dto) {
        /***************************************************
         * Il faut valider le UserBM dto pris en arguments
         */
        List<String> errors = UserBMDtoValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Entity userBM not valid {}", dto);
            throw new InvalidEntityException("Le userBM passé en argument n'est pas valide: ",
                    ErrorCode.USERBM_NOT_VALID, errors);
        }

        /*****************************************************
         * Il faut se rassurer de l'unicite du cni du User
         */
        Optional<UserBM> optionalUserBMcni = userBMRepository.findUserBMByCni(dto.getBmCni());
        if(optionalUserBMcni.isPresent()){
            /*******************************************************************
             * Si c'est present alors le nouveau User envoye ne sera pas unique
             */
            log.error("A UserBM already exist with the same cni number {}", dto.getBmCni());
            throw new DuplicateEntityException("Un UserBM existe deja en BD avec le meme cni number ",
                    ErrorCode.USERBM_DUPLICATED);
        }

        /****************************************************
         * Il faut se rassurer de l'unicite du login du User
         */
        Optional<UserBM> optionalUserBMlogin = userBMRepository.findUserBMByLogin(dto.getBmLogin());
        if(optionalUserBMlogin.isPresent()){
            /*******************************************************************
             * Si c'est present alors le nouveau User envoye ne sera pas unique
             */
            log.error("A UserBM already exist with the same login {}", dto.getBmLogin());
            throw new DuplicateEntityException("Un UserBM existe deja en BD avec le meme login ",
                    ErrorCode.USERBM_DUPLICATED);
        }

        /*******************************************************
         * Il faut se rassurer de l'unicite du Fullname du User
         */
        Optional<UserBM> optionalUserBMfullname = userBMRepository.findUserBMByFullname(dto.getBmName(), dto.getBmSurname(),
                dto.getBmDob());
        if(optionalUserBMfullname.isPresent()){
            /*******************************************************************
             * Si c'est present alors le nouveau User envoye ne sera pas unique
             */
            log.error("A UserBM already exist with the same Fullname {} {} {}", dto.getBmName(), dto.getBmSurname(),
                    dto.getBmDob());
            throw new DuplicateEntityException("Un UserBM existe deja en BD avec le meme Fullname  ",
                    ErrorCode.USERBM_DUPLICATED);
        }

        /********************************************************
         * Il faut se rassurer de l'unicite de l'email precise
         * dans l'adresse du User
         */
        Optional<UserBM> optionalUserBMemail = userBMRepository.findUserBMByEmail(dto.getBmAddressDto().getEmail());
        if(optionalUserBMemail.isPresent()){
            /*******************************************************************
             * Si c'est present alors le nouveau User envoye ne sera pas unique
             */
            log.error("A UserBM already exist with the same email {}", dto.getBmAddressDto().getEmail());
            throw new DuplicateEntityException("Un UserBM existe deja en BD avec le meme email  ",
                    ErrorCode.USERBM_DUPLICATED);
        }

        /*****************************************************
         * Il faut crypter le mot de pase avec bcrypt
         */
//        BCryptPasswordEncoder p = new BCryptPasswordEncoder();
//        dto.setBmPassword(p.encode(dto.getBmPassword()));
//        dto.setBmRepassword(p.encode(dto.getBmRepassword()));


        /********************************************************
         * Il faut maintenant aiguiller la suite en fonction du
         * type de User(Admin, AdminEnterprise ou Employe)
         */
        if(dto.getBmUsertype().equals(UserBMType.AdminBM.name())){
            log.info("On lance l'enregistrement d'un AdminBM");
            return this.saveUserBMAdmin(dto);
        }
        return null;
    }

    private UserBMDto saveUserBMAdmin(UserBMDto dto){

        /*********************************************
         * Aucune autre verification n'est a faire car
         * il s'agit d'un admin de la plateforme
         */
        //Aucune entreprise
        dto.setEntUserbmId(Long.valueOf(0));
        //Aucun point of sale
        dto.setPosUserbmId(Long.valueOf(0));

        UserBM userBMSaved = userBMRepository.save(UserBMDto.toEntity(dto));

        return UserBMDto.fromEntity(
                userBMSaved
        );
    }

    private UserBMDto saveUserBMAdminEnterprise(UserBMDto dto){
        /*************************************
         * Il faut verifier que l'id de l'entreprise est bien precise
         * et que cet id identifie vraiment une entreprise
         * Aucun pointofsale
         */

        return null;
    }

    private UserBMDto saveUserBMEmploye(UserBMDto dto){
        /***************************************************
         * Il faut verifier que l'id du pointofsale est bien precise
         * et que ca identifie vraiment un pointofsale
         * L'entreprise correspondante sera celle du pointofsale indique
         */

        return null;
    }

    @Override
    public UserBMDto updateUserBM(UserBMDto dto) {
        return null;
    }

    @Override
    public Boolean deleteUserBMById(Long id) {
        return null;
    }

    @Override
    public List<UserBMDto> findAllUserBM(String keyword) {
        return null;
    }

    @Override
    public Page<UserBMDto> findPageUserBM(String keyword, int pagenum, int pagesize) {
        return null;
    }
}
