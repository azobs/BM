package com.c2psi.bm.controllers.api.pos.userbm;

import com.c2psi.bm.dtos.pos.userbm.UserBMDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static com.c2psi.bm.utils.pos.userbm.UserBMApiConstant.CREATE_USERBM_ENDPOINT;
import static com.c2psi.bm.utils.pos.userbm.UserBMApiConstant.USERBM_ENDPOINT;

@Validated
@Api(USERBM_ENDPOINT)
public interface UserBMApi {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(value = CREATE_USERBM_ENDPOINT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create or Persist a user BM in the DB",
            notes = "This method is used to save or create a userBM in the DB",
            response = UserBMDto.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Object UserBM added/created successfully"),
            @ApiResponse(code=400, message="The execution of the request encounter a problem")
    })
    ResponseEntity saveUserBM(
            @ApiParam(name = "userBMDto", type = "UserBMDto", required = true,
                    value="The JSON object that represent the UserBM to save")
            @Valid @RequestBody UserBMDto userBMDto, BindingResult bindingResult
            /*@RequestParam(name="picture")MultipartFile filephotoPers*/);
    //throws BMException;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
