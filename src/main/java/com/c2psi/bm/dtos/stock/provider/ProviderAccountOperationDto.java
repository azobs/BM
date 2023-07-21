package com.c2psi.bm.dtos.stock.provider;


import com.c2psi.bm.dtos.OperationDto;
import com.c2psi.bm.models.ProviderAccountOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class ProviderAccountOperationDto {

    @ApiModelProperty(value = "The Provider account operation id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The number in mouvement in the operation can't be null")
    @Positive(message = "The number in mouvement in the operation must be positive")
    @ApiModelProperty(value = "The number in mouvement in the operation", name = "paoNumberinmvt",
            dataType = "BigDecimal", required = true, example = "1")
    BigDecimal paoNumberinmvt;

    @NotNull(message = "The operation associate can't be null")
    @ApiModelProperty(value = "The operation associate", name = "paoOperationDto", dataType = "OperationDto")
    OperationDto paoOperationDto;

    @NotNull(message = "The provider account link with the operation can't be null")
    @ApiModelProperty(value = "The provider account link with the operation", name = "paoProviderAccountDto",
            dataType = "ProviderAccountDto")
    ProviderAccountDto paoProviderAccountDto;

    public static ProviderAccountOperationDto fromEntity(ProviderAccountOperation entity){

        if(entity == null) return null;
        return ProviderAccountOperationDto.builder()
                .id(entity.getId())
                .paoNumberinmvt(entity.getPaoNumberinmvt())
                .paoOperationDto(OperationDto.fromEntity(entity.getPaoOperation()))
                .paoProviderAccountDto(ProviderAccountDto.fromEntity(entity.getPaoProviderAccount()))

                .build();
    }

    public static ProviderAccountOperation  toEntity(ProviderAccountOperationDto dto){

        if(dto == null) return null;
        ProviderAccountOperation entity = new ProviderAccountOperation();

        entity.setId(dto.getId());
        entity.setPaoNumberinmvt(dto.getPaoNumberinmvt());
        entity.setPaoOperation(OperationDto.toEntity(dto.getPaoOperationDto()));
        entity.setPaoProviderAccount(ProviderAccountDto.toEntity(dto.getPaoProviderAccountDto()));

        return entity;
    }
}
