package com.c2psi.bm.dtos.pos.pos;


import com.c2psi.bm.dtos.AddressDto;
import com.c2psi.bm.dtos.stock.price.CurrencyDto;
import com.c2psi.bm.models.Pointofsale;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class PointofsaleDto {
    @ApiModelProperty(value = "The Pointofsale Id", name = "id", dataType = "Long")
    Long id;

    @NotEmpty(message = "The pointofsale acronym can't be empty")
    @NotBlank(message = "The pointofsale acronym can't be blank")
    @Size(max = 10, message = "The pointofsale acronym size can't be above 10")
    @ApiModelProperty(value = "The Pointofsale Acronym", name = "posAcronym", dataType = "String")
    String posAcronym;

    @NotNull(message = "The pointofsale address can't be null")
    @ApiModelProperty(value = "The Pointofsale Address", name = "posAddressDto", dataType = "AddressDto")
    AddressDto posAddressDto;

    @NotNull(message = "The cash Account balance can't be null")
    @ApiModelProperty(value = "The cash Account balance of the Pointofsale", name = "posBalance",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal posBalance;

    @NotNull(message = "The Pointofsale default currency can't be null")
    @ApiModelProperty(value = "The Pointofsale default currency", name = "posCurrencyDto", dataType = "CurrencyDto")
    CurrencyDto posCurrencyDto;

    @NotEmpty(message = "The Pointofsale description can't be empty")
    @NotBlank(message = "The Pointofsale description can't be blank")
    @Size(max = 100, message = "The Pointofsale description size can't be above 100")
    @ApiModelProperty(value = "The Pointofsale description", name = "posDescription", dataType = "String")
    String posDescription;

    @NotNull(message = "The Enterprise that the Pointofsale belong to can't be null")
    @ApiModelProperty(value = "The Enterprise that the Pointofsale belong to", name = "posEnterpriseDto",
            dataType = "EnterpriseDto")
    EnterpriseDto posEnterpriseDto;

    @NotNull(message = "The Pointofsale name can't be null")
    @NotEmpty(message = "The Pointofsale name can't be empty")
    @NotBlank(message = "The Pointofsale name can't be blank")
    @Size(max = 50, message = "The Pointofsale name size can't be above 50")
    @ApiModelProperty(value = "The Pointofsale name", name = "posName", dataType = "String", required = true,
            example = "PosName")
    String posName;


    public static PointofsaleDto fromEntity(Pointofsale entity){

        if(entity == null) return null;
        return PointofsaleDto.builder()
                .id(entity.getId())
                .posAcronym(entity.getPosAcronym())
                .posAddressDto(AddressDto.fromEntity(entity.getPosAddress()))
                .posBalance(entity.getPosBalance())
                .posCurrencyDto(CurrencyDto.fromEntity(entity.getPosCurrency()))
                .posDescription(entity.getPosDescription())
                .posEnterpriseDto(EnterpriseDto.fromEntity(entity.getPosEnterprise()))
                .posName(entity.getPosName())

                .build();
    }

    public static Pointofsale  toEntity(PointofsaleDto dto){

        if(dto == null) return null;
        Pointofsale entity = new Pointofsale();

        entity.setId(dto.getId());
        entity.setPosAcronym(dto.getPosAcronym());
        entity.setPosAddress(AddressDto.toEntity(dto.getPosAddressDto()));
        entity.setPosBalance(dto.getPosBalance());
        entity.setPosCurrency(CurrencyDto.toEntity(dto.getPosCurrencyDto()));
        entity.setPosDescription(dto.getPosDescription());
        entity.setPosEnterprise(EnterpriseDto.toEntity(dto.getPosEnterpriseDto()));
        entity.setPosName(dto.getPosName());

        return entity;
    }
}
