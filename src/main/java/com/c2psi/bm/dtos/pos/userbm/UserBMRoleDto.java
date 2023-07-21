package com.c2psi.bm.dtos.pos.userbm;

import com.c2psi.bm.models.UserBMRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;

@Data
@Builder
@ApiModel
public class UserBMRoleDto {
    @ApiModelProperty(value = "The UserBMRole id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The date of the attribution of the role to the userbm can't be null")
    @PastOrPresent(message = "The attribution date can't be in the future")
    @ApiModelProperty(value = "The date of the attribution of the role to the userbm", name = "userbmroleAttributionDate",
            dataType = "Instant")
    Instant userbmroleAttributionDate;

    @NotNull(message = "The role attributed to the userbm can't be null")
    @ApiModelProperty(value = "The role attributed", name = "userbmroleRoleDto", dataType = "RoleDto")
    RoleDto userbmroleRoleDto;

    @NotNull(message = "The userbm associated to the role can't be null")
    @ApiModelProperty(value = "The UserBM associated to the role", name = "userbmroleUserbmDto", dataType = "UserBMDto")
    UserBMDto userbmroleUserbmDto;


    public static UserBMRoleDto fromEntity(UserBMRole entity){

        if(entity == null) return null;
        return UserBMRoleDto.builder()
                .id(entity.getId())
                .userbmroleAttributionDate(entity.getUserbmroleAttributionDate())
                .userbmroleRoleDto(RoleDto.fromEntity(entity.getUserbmroleRole()))
                .userbmroleUserbmDto(UserBMDto.fromEntity(entity.getUserbmroleUserbm()))

                .build();
    }

    public static UserBMRole toEntity(UserBMRoleDto dto){

        if(dto == null) return null;
        UserBMRole entity = new UserBMRole();

        entity.setId(dto.getId());
        entity.setUserbmroleAttributionDate(dto.getUserbmroleAttributionDate());
        entity.setUserbmroleRole(RoleDto.toEntity(dto.getUserbmroleRoleDto()));
        entity.setUserbmroleUserbm(UserBMDto.toEntity(dto.getUserbmroleUserbmDto()));

        return entity;
    }
}
