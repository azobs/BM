package com.c2psi.bm.dtos.stock.product;


import com.c2psi.bm.models.Unit;
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
public class UnitDto {
    @ApiModelProperty(value = "The Unit id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The pointofsale id of the Unit can't be null")
    @ApiModelProperty(value = "The pointofsale id of the Unit", name = "posUnitId", dataType = "Long", required = true,
             example = "0")
    Long posUnitId;

    @NotEmpty(message = "The Unit abbreviation can't be empty")
    @NotBlank(message = "The Unit abbreviation can't be blank")
    @Size(max = 10, message = "The Unit abbreviation size can't be above 10")
    @ApiModelProperty(value = "The Unit abbreviation", name = "unitAbbreviation", dataType = "String")
    String unitAbbreviation;

    @NotNull(message = "The Unit name can't be null")
    @NotEmpty(message = "The Unit name can't be empty")
    @NotBlank(message = "The Unit name can't be blank")
    @Size(max = 10, message = "The Unit name size can't be above 10")
    @ApiModelProperty(value = "The Unit name", name = "unitName", dataType = "String",
            required = true, example = "UnitName")
    String unitName;


    public static UnitDto fromEntity(Unit entity){

        if(entity == null) return null;
        return UnitDto.builder()
                .id(entity.getId())
                .posUnitId(entity.getPosUnitId())
                .unitAbbreviation(entity.getUnitAbbreviation())
                .unitName(entity.getUnitName())

                .build();
    }

    public static Unit toEntity(UnitDto dto){

        if(dto == null) return null;
        Unit entity = new Unit();
        entity.setId(dto.getId());
        entity.setPosUnitId(dto.getPosUnitId());
        entity.setUnitAbbreviation(dto.getUnitAbbreviation());
        entity.setUnitName(dto.getUnitName());

        return entity;
    }
}
