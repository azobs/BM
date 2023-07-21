package com.c2psi.bm.dtos.pos.userbm;

import com.c2psi.bm.enumerations.RoleNature;
import com.c2psi.bm.models.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@ApiModel
public class RoleDto {
    @ApiModelProperty(value = "The Role Id", name = "id", dataType = "Long")
    Long id;

    @NotEmpty(message = "The role alias can't be empty")
    @NotBlank(message = "The role alias can't be blank")
    @Size(max = 20, message = "The role alias size can't be above 20")
    @ApiModelProperty(value = "The Role alias", name = "roleAlias", dataType = "String")
    String roleAlias;

    @NotEmpty(message = "The role description can't be empty")
    @NotBlank(message = "The role description can't be blank")
    @Size(max = 100, message = "The role description size can't be above 100")
    @ApiModelProperty(value = "The Role description", name = "roleDescription", dataType = "String")
    String roleDescription;

    @NotNull(message = "The role name can't be null")
    @NotEmpty(message = "The role name can't be empty")
    @NotBlank(message = "The role name can't be blank")
    @Size(max = 20, message = "The role name size can't be above 20")
    @ApiModelProperty(value = "The Role name", name = "roleName", dataType = "String", required = true,
            allowableValues = "Admin, AdminEnterprise, Deliver, Dg, Manager, Pdg, Saler, Storekeeper", example = "Admin")
    String roleName;


    public static RoleDto fromEntity(Role entity){

        if(entity == null) return null;
        return RoleDto.builder()
                .id(entity.getId())
                .roleAlias(entity.getRoleAlias())
                .roleDescription(entity.getRoleDescription())
                .roleName(entity.getRoleName().name())

                .build();
    }

    public static Role  toEntity(RoleDto dto){

        if(dto == null) return null;
        Role entity = new Role();

        entity.setId(dto.getId());
        entity.setRoleAlias(dto.getRoleAlias());
        entity.setRoleDescription(dto.getRoleDescription());
        entity.setRoleName(
                dto.getRoleName().equalsIgnoreCase(RoleNature.Admin.name()) ? RoleNature.Admin :
                dto.getRoleName().equalsIgnoreCase(RoleNature.AdminEnterprise.name()) ? RoleNature.AdminEnterprise :
                dto.getRoleName().equalsIgnoreCase(RoleNature.Deliver.name()) ? RoleNature.Deliver :
                dto.getRoleName().equalsIgnoreCase(RoleNature.Dg.name()) ? RoleNature.Dg :
                dto.getRoleName().equalsIgnoreCase(RoleNature.Manager.name()) ? RoleNature.Manager :
                dto.getRoleName().equalsIgnoreCase(RoleNature.Pdg.name()) ? RoleNature.Pdg :
                dto.getRoleName().equalsIgnoreCase(RoleNature.Saler.name()) ? RoleNature.Saler :
                        RoleNature.Storekeeper
        );

        return entity;
    }
}
