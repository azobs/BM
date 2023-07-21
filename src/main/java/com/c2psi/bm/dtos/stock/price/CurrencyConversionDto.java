package com.c2psi.bm.dtos.stock.price;


import com.c2psi.bm.models.CurrencyConversion;
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
public class CurrencyConversionDto {
    @NotNull(message = "The currency destination can't be null")
    @ApiModelProperty(value = "The currency destination of the conversion rule", name = "currencyDestinationDto",
            dataType = "CurrencyDto")
    CurrencyDto currencyDestinationDto;

    @NotNull(message = "The conversion factor can't be null")
    @Positive(message = "The conversion factor of a conversion rule can't be negative")
    @ApiModelProperty(value = "The currencyconversion factor", name = "conversionFactor", dataType = "BigDecimal",
            required = true, example = "1")
    BigDecimal conversionFactor;

    @NotNull(message = "The currency source can't be null")
    @ApiModelProperty(value = "The currency source of the conversion rule", name = "currencySourceDto",
            dataType = "CurrencyDto")
    CurrencyDto currencySourceDto;

    @ApiModelProperty(value = "The currencyconversion id", name = "id", dataType = "Long")
    Long id;


    public static CurrencyConversionDto fromEntity(CurrencyConversion entity){

        if(entity == null) return null;
        return CurrencyConversionDto.builder()
                .currencyDestinationDto(CurrencyDto.fromEntity(entity.getCurrencyDestination()))
                .conversionFactor(entity.getConversionFactor())
                .currencySourceDto(CurrencyDto.fromEntity(entity.getCurrencySource()))
                .id(entity.getId())

                .build();
    }

    public static CurrencyConversion  toEntity(CurrencyConversionDto dto){

        if(dto == null) return null;
        CurrencyConversion entity = new CurrencyConversion();

        entity.setCurrencyDestination(CurrencyDto.toEntity(dto.getCurrencyDestinationDto()));
        entity.setConversionFactor(dto.getConversionFactor());
        entity.setCurrencySource(CurrencyDto.toEntity(dto.getCurrencySourceDto()));
        entity.setId(dto.getId());

        return entity;
    }
}
