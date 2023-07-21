package com.c2psi.bm.dtos.stock.price;

import com.c2psi.bm.models.Currency;
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
public class CurrencyDto {
    @NotNull(message = "The currency name can't be null")
    @NotEmpty(message = "The currency name can't be empty")
    @NotBlank(message = "The currency name can't be blank")
    @Size(max = 20, message = "The currency name size can't be above 20")
    @ApiModelProperty(value = "The Currency name", name = "currencyName", dataType = "String", required = true,
            example = "Franc cfa")
    String currencyName;

    @NotNull(message = "The currency shortname can't be null")
    @NotEmpty(message = "The currency shortname can't be empty")
    @NotBlank(message = "The currency shortname can't be blank")
    @Size(max = 10, message = "The currency shortname size can't be above 10")
    @ApiModelProperty(value = "The Currency shortname", name = "currencyShortname", dataType = "String", required = true,
            example = "F cfa")
    String currencyShortname;

    @ApiModelProperty(value = "The Currency id", name = "id", dataType = "Long")
    Long id;

    public static CurrencyDto fromEntity(Currency entity){

        if(entity == null) return null;
        return CurrencyDto.builder()
                .currencyName(entity.getCurrencyName())
                .currencyShortname(entity.getCurrencyShortname())
                .id(entity.getId())

                .build();
    }

    public static Currency  toEntity(CurrencyDto dto){

        if(dto == null) return null;
        Currency entity = new Currency();
        entity.setCurrencyName(dto.getCurrencyName());
        entity.setCurrencyShortname(dto.getCurrencyShortname());
        entity.setId(dto.getId());

        return entity;
    }
}
