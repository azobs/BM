package com.c2psi.bm.dtos.pos.pos;


import com.c2psi.bm.dtos.OperationDto;
import com.c2psi.bm.models.PosAccountOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class PosAccountOperationDto {
    @ApiModelProperty(value = "The PosAccountOperation Id", name = "id", dataType = "Long")
    Long id;

    @NotEmpty(message = "The number in mouvement can't be empty")
    @Positive(message = "The number in mouvement must be positive")
    @ApiModelProperty(value = "The number in mouvement in the PosAccountOperation", name = "paNumberinmvt",
            dataType = "BigDecimal", required = true, example = "1")
    BigDecimal paNumberinmvt;

    @NotEmpty(message = "The operation associate can't be empty")
    @ApiModelProperty(value = "The operation associate with the PosAccountOperation", name = "paOperationDto",
            dataType = "OperationDto")
    OperationDto paOperationDto;

    @NotEmpty(message = "The PosAccount associate can't be empty")
    @ApiModelProperty(value = "The PosAccount associate with the PosAccountOperation", name = "paoPosAccountDto",
            dataType = "PosAccountDto")
    PosAccountDto paoPosAccountDto;


    public static PosAccountOperationDto fromEntity(PosAccountOperation entity){

        if(entity == null) return null;
        return PosAccountOperationDto.builder()
                .id(entity.getId())
                .paNumberinmvt(entity.getPaNumberinmvt())
                .paOperationDto(OperationDto.fromEntity(entity.getPaOperation()))
                .paoPosAccountDto(PosAccountDto.fromEntity(entity.getPaoPosAccount()))

                .build();
    }

    public static PosAccountOperation  toEntity(PosAccountOperationDto dto){

        if(dto == null) return null;
        PosAccountOperation entity = new PosAccountOperation();

        entity.setId(dto.getId());
        entity.setPaNumberinmvt(dto.getPaNumberinmvt());
        entity.setPaOperation(OperationDto.toEntity(dto.getPaOperationDto()));
        entity.setPaoPosAccount(PosAccountDto.toEntity(dto.getPaoPosAccountDto()));

        return entity;
    }
}
