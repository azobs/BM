package com.c2psi.bm.dtos.stock.product;

import com.c2psi.bm.models.UnitConversion;
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
public class UnitConversionDto {
    @NotNull(message = "The conversion factor can't be null")
    @Positive(message = "The conversion factor must be positive")
    @ApiModelProperty(value = "The conversion factor in the conversion rule", name = "conversionFactor",
            dataType = "BigDecimal")
    BigDecimal conversionFactor;

    @ApiModelProperty(value = "The Unit conversion id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The Unit destination can't be null")
    @ApiModelProperty(value = "The Unit destination  in the rule", name = "unitDestinationDto", dataType = "UnitDto")
    UnitDto unitDestinationDto;

    @NotNull(message = "The Unit source can't be null")
    @ApiModelProperty(value = "The Unit source  in the rule", name = "unitSourceDto", dataType = "UnitDto")
    UnitDto unitSourceDto;


    public static UnitConversionDto fromEntity(UnitConversion entity){

        if(entity == null) return null;
        return UnitConversionDto.builder()
                .conversionFactor(entity.getConversionFactor())
                .id(entity.getId())
                .unitDestinationDto(UnitDto.fromEntity(entity.getUnitDestination()))
                .unitSourceDto(UnitDto.fromEntity(entity.getUnitSource()))

                .build();
    }

    public static UnitConversion  toEntity(UnitConversionDto dto){

        if(dto == null) return null;
        UnitConversion entity = new UnitConversion();
        entity.setConversionFactor(dto.getConversionFactor());
        entity.setId(dto.getId());
        entity.setUnitDestination(UnitDto.toEntity(dto.getUnitDestinationDto()));
        entity.setUnitSource(UnitDto.toEntity(dto.getUnitSourceDto()));

        return entity;
    }
}
