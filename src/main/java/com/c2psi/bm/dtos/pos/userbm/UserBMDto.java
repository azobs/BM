package com.c2psi.bm.dtos.pos.userbm;

import com.c2psi.bm.dtos.AddressDto;
import com.c2psi.bm.enumerations.UserBMState;
import com.c2psi.bm.enumerations.UserBMType;
import com.c2psi.bm.models.UserBM;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@ApiModel
public class UserBMDto {
    @NotNull(message = "The UserBM address can't be null")
    @ApiModelProperty(value = "The Address of the UserBM", name = "bmAddressDto", dataType = "AddressDto")
    AddressDto bmAddressDto;

    @NotEmpty(message = "The UserBM cni number can't be empty")
    @NotBlank(message = "The UserBM cni number can't be blank")
    @Size(max = 10, message = "The UserBM cni number size can't be above 10")
    @ApiModelProperty(value = "The cni number of the UserBM", name = "bmCni", dataType = "String")
    String bmCni;

    @ApiModelProperty(value = "The date of birth of the UserBM", name = "bmDob", dataType = "Date")
    Date bmDob;

    @NotNull(message = "The UserBM login can't be null")
    @NotEmpty(message = "The UserBM login can't be empty")
    @NotBlank(message = "The UserBM login can't be blank")
    @Size(max = 20, message = "The UserBM login size can't be above 20")
    @ApiModelProperty(value = "The login of the UserBM", name = "bmLogin", dataType = "String", required = true,
            example = "UserLogin")
    String bmLogin;

    @NotNull(message = "The UserBM name can't be null")
    @NotEmpty(message = "The UserBM name can't be empty")
    @NotBlank(message = "The UserBM name can't be blank")
    @Size(max = 20, message = "The UserBM name size can't be above 20")
    @ApiModelProperty(value = "The name of the UserBM", name = "bmName", dataType = "String", required = true,
            example = "UserName")
    String bmName;

    @NotNull(message = "The UserBM password can't be null")
    @NotEmpty(message = "The UserBM password can't be empty")
    @NotBlank(message = "The UserBM password can't be blank")
    @ApiModelProperty(value = "The password of the UserBM", name = "bmPassword", dataType = "String", required = true,
            example = "UserPassword")
    String bmPassword;

    @NotEmpty(message = "The UserBM picture can't be empty")
    @NotBlank(message = "The UserBM picture can't be blank")
    @Size(max = 20, message = "The UserBM picture size can't be above 20")
    @ApiModelProperty(value = "The picture of the UserBM", name = "bmPicture", dataType = "String")
    String bmPicture;

    @NotNull(message = "The UserBM Repassword can't be null")
    @NotEmpty(message = "The UserBM Repassword can't be empty")
    @NotBlank(message = "The UserBM Repassword can't be blank")
    @ApiModelProperty(value = "The Repassword of the UserBM", name = "bmPassword", dataType = "String", required = true,
            example = "UserPassword")
    String bmRePassword;

    @NotNull(message = "The UserBM state can't be null")
    @NotEmpty(message = "The UserBM state can't be empty")
    @NotBlank(message = "The UserBM state can't be blank")
    @Size(max = 15, message = "The UserBM state size can't be above 15")
    @ApiModelProperty(value = "The UserBM state", name = "bmUserState", dataType = "String", required = true,
            allowableValues = "Activated, Connected, Deactivated,  Disconnected", example = "Activated")
    String bmUserState;

    @NotEmpty(message = "The UserBM login can't be empty")
    @NotBlank(message = "The UserBM login can't be blank")
    @Size(max = 20, message = "The UserBM login size can't be above 20")
    @ApiModelProperty(value = "The UserBM surname", name = "bmSurname", dataType = "String")
    String bmSurname;

    @NotNull(message = "The UserBM type can't be null")
    @NotEmpty(message = "The UserBM type can't be empty")
    @NotBlank(message = "The UserBM type can't be blank")
    @Size(max = 20, message = "The UserBM type size can't be above 20")
    @ApiModelProperty(value = "The UserBM type", name = "bmUsertype", dataType = "String", required = true,
            allowableValues = "AdminBM, AdminEnterprise, Employe", example = "AdminBM")
    String bmUsertype;

    @ApiModelProperty(value = "The enterprise id in which the user is", name = "entUserbmId", dataType = "Long")
    Long entUserbmId;

    @ApiModelProperty(value = "The UserBM Id", name = "id", dataType = "Long")
    Long id;

    @ApiModelProperty(value = "The pointofsale id in which the user is", name = "posUserbmId", dataType = "Long")
    Long posUserbmId;


    public static UserBMDto fromEntity(UserBM entity){
        if(entity == null) return null;
        return UserBMDto.builder()
                .bmAddressDto(AddressDto.fromEntity(entity.getBmAddress()))
                .bmCni(entity.getBmCni())
                .bmDob(entity.getBmDob())
                .bmLogin(entity.getBmLogin())
                .bmName(entity.getBmName())
                .bmPassword(entity.getBmPassword())
                .bmPicture(entity.getBmPicture())
                .bmRePassword(entity.getBmPassword())
                .bmUserState(entity.getBmUserState().name())
                .bmSurname(entity.getBmSurname())
                .bmUsertype(entity.getBmUsertype().name())
                .entUserbmId(entity.getEntUserbmId())
                .id(entity.getId())
                .posUserbmId(entity.getPosUserbmId())

                .build();
    }

    public static UserBM  toEntity(UserBMDto dto){
        if(dto == null) return null;
        UserBM entity = new UserBM();

        entity.setBmAddress(AddressDto.toEntity(dto.getBmAddressDto()));
        entity.setBmCni(dto.getBmCni());
        entity.setBmDob(dto.getBmDob());
        entity.setBmLogin(dto.getBmLogin());
        entity.setBmName(dto.getBmName());
        entity.setBmPassword(dto.getBmPassword());
        entity.setBmPicture(dto.getBmPicture());
        entity.setBmUserState(
                dto.getBmUserState().equalsIgnoreCase(UserBMState.Activated.name()) ? UserBMState.Activated :
                dto.getBmUserState().equalsIgnoreCase(UserBMState.Connected.name()) ? UserBMState.Connected :
                dto.getBmUserState().equalsIgnoreCase(UserBMState.Deactivated.name()) ? UserBMState.Deactivated :
                        UserBMState.Disconnected
        );
        entity.setBmSurname(dto.getBmSurname());
        entity.setBmUsertype(
                dto.getBmUsertype().equalsIgnoreCase(UserBMType.AdminBM.name()) ? UserBMType.AdminBM :
                dto.getBmUsertype().equalsIgnoreCase(UserBMType.AdminEnterprise.name()) ? UserBMType.AdminEnterprise :
                        UserBMType.Employe
        );
        entity.setEntUserbmId(dto.getEntUserbmId());
        entity.setId(dto.getId());
        entity.setPosUserbmId(dto.getPosUserbmId());

        return entity;
    }
}
