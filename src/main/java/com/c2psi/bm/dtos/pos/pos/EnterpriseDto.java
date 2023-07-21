package com.c2psi.bm.dtos.pos.pos;


import com.c2psi.bm.dtos.AddressDto;
import com.c2psi.bm.dtos.pos.userbm.UserBMDto;
import com.c2psi.bm.models.Enterprise;
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
public class EnterpriseDto {
    @NotNull(message = "The enterprise acronym can't be null")
    @NotEmpty(message = "The enterprise acronym can't be empty")
    @NotBlank(message = "The enterprise acronym can't be blank")
    @Size(max = 10, message = "The enterprise acronym size can't be above 10")
    @ApiModelProperty(value = "The Enterprise Acronym", name = "entAcronym", dataType = "String")
    String entAcronym;

    @NotNull(message = "The enterprise address can't be null")
    @ApiModelProperty(value = "The Enterprise address", name = "entAddressDto", dataType = "AddressDto")
    AddressDto entAddressDto;

    @NotNull(message = "The enterprise userbm admin can't be null")
    @ApiModelProperty(value = "The UserBM admin of the enterprise", name = "entAdminDto", dataType = "UserBMDto")
    UserBMDto entAdminDto;

    @NotEmpty(message = "The enterprise description can't be empty")
    @NotBlank(message = "The enterprise description can't be blank")
    @Size(max = 100, message = "The enterprise description size can't be above 100")
    @ApiModelProperty(value = "The enterprise description", name = "entDescription", dataType = "String")
    String entDescription;

    @NotEmpty(message = "The enterprise logo can't be empty")
    @NotBlank(message = "The enterprise logo can't be blank")
    @Size(max = 25, message = "The enterprise logo size can't be above 25")
    @ApiModelProperty(value = "The logo name of the enterprise", name = "entLogo", dataType = "String")
    String entLogo;

    @NotNull(message = "The enterprise name can't be null")
    @NotEmpty(message = "The enterprise name can't be empty")
    @NotBlank(message = "The enterprise name can't be blank")
    @Size(max = 75, message = "The enterprise acronym size can't be above 75")
    @ApiModelProperty(value = "The enterprise name", name = "entName", dataType = "String", required = true,
            example = "EntName")
    String entName;

    @NotNull(message = "The enterprise NIU can't be null")
    @NotEmpty(message = "The enterprise NIU can't be empty")
    @NotBlank(message = "The enterprise NIU can't be blank")
    @Size(max = 20, message = "The enterprise NIU size can't be above 20")
    @ApiModelProperty(value = "The enterprise Niu", name = "entNiu", dataType = "String", required = true,
            example = "EntNiu")
    String entNiu;

    @NotEmpty(message = "The enterprise regime can't be empty")
    @NotBlank(message = "The enterprise regime can't be blank")
    @Size(max = 20, message = "The enterprise regime size can't be above 20")
    @ApiModelProperty(value = "The enterprise regime", name = "entRegime", dataType = "String")
    String entRegime;

    @NotEmpty(message = "The enterprise raison sociale can't be empty")
    @NotBlank(message = "The enterprise raison sociale can't be blank")
    @Size(max = 20, message = "The enterprise raison sociale size can't be above 20")
    @ApiModelProperty(value = "The enterprise raison sociale", name = "entSocialreason", dataType = "String")
    String entSocialreason;

    @ApiModelProperty(value = "The Enterprise id ", name = "id", dataType = "Long")
    Long id;


    public static EnterpriseDto fromEntity(Enterprise entity){

        if(entity == null) return null;
        return EnterpriseDto.builder()
                .entAcronym(entity.getEntAcronym())
                .entAddressDto(AddressDto.fromEntity(entity.getEntAddress()))
                .entAdminDto(UserBMDto.fromEntity(entity.getEntAdmin()))
                .entDescription(entity.getEntDescription())
                .entLogo(entity.getEntLogo())
                .entName(entity.getEntName())
                .entNiu(entity.getEntNiu())
                .entRegime(entity.getEntRegime())
                .entSocialreason(entity.getEntSocialreason())
                .id(entity.getId())

                .build();
    }

    public static Enterprise  toEntity(EnterpriseDto dto){

        if(dto == null) return null;
        Enterprise entity = new Enterprise();

        entity.setEntAcronym(dto.getEntAcronym());
        entity.setEntAddress(AddressDto.toEntity(dto.getEntAddressDto()));
        entity.setEntAdmin(UserBMDto.toEntity(dto.getEntAdminDto()));
        entity.setEntDescription(dto.getEntDescription());
        entity.setEntLogo(dto.getEntLogo());
        entity.setEntName(dto.getEntName());
        entity.setEntNiu(dto.getEntNiu());
        entity.setEntRegime(dto.getEntRegime());
        entity.setEntSocialreason(dto.getEntSocialreason());
        entity.setId(dto.getId());

        return entity;
    }
}
