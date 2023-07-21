package com.c2psi.bm.controllers.apiImpl.pos.userbm;

import com.c2psi.bm.controllers.api.pos.userbm.UserBMApi;
import com.c2psi.bm.dtos.pos.userbm.UserBMDto;
import com.c2psi.bm.services.contract.pos.userbm.UserBMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserBMApiImpl implements UserBMApi {
    private UserBMService userBMService;

    @Autowired
    public UserBMApiImpl(UserBMService userBMService) {
        this.userBMService = userBMService;
    }

    @Override
    public ResponseEntity saveUserBM(UserBMDto userBMDto, BindingResult bindingResult) {
        Map<String, Object> map = new LinkedHashMap<>();

        if (bindingResult.hasErrors()) {
            log.info("Error during the pre-validation of the model passed in argument {} " +
                    "and the report errors are {}", userBMDto, bindingResult);
            //return ResponseEntity.badRequest().body(bindingResult.toString());
            map.clear();
            map.put("status", HttpStatus.BAD_REQUEST);
            map.put("message", "Some data are not validated");
            map.put("data", bindingResult);
            map.put("cause", "Erreur de validation des donnees dans la requete envoyee");
            //return ResponseEntity.ok(map);
            return ResponseEntity.badRequest().body(map);
        }

        log.info("Entity UserBM to save is {} ", userBMDto);
        UserBMDto userBMDtoSaved = userBMService.saveUserBM(userBMDto);
        log.info("Entity UserBM saved successfully {} ", userBMDtoSaved);

        map.clear();
        map.put("status", HttpStatus.CREATED);
        map.put("message", "UserBM created successfully");
        map.put("data", userBMDtoSaved);
        map.put("cause", "RAS");
        return new ResponseEntity(map, HttpStatus.CREATED);
    }
}
