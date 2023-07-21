package com.c2psi.bm.dtos.stock.price;

import com.c2psi.bm.models.Baseprice;
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
public class BasepriceDto {
    @NotNull(message = "The associate Currency of the baseprice can't be null")
    @ApiModelProperty(value = "The Currency of the Baseprice", name = "bpCurrencyDto", dataType = "CurrencyDto")
    CurrencyDto bpCurrencyDto;

    @NotNull(message = "The detail price in the baseprice can't be null")
    @Positive(message = "The detail price must be positive")
    @ApiModelProperty(value = "The detail price in the Baseprice", name = "bpDetailprice", dataType = "BigDecimal",
            required = true, example = "0")
    BigDecimal bpDetailprice;

    @NotNull(message = "The expected precompte in the baseprice can't be null")
    @ApiModelProperty(value = "The expected precompte in the Baseprice", name = "bpPrecompte", dataType = "BigDecimal",
            required = true, example = "0")
    BigDecimal bpPrecompte;

    @NotNull(message = "The purchase price in the baseprice can't be null")
    @Positive(message = "The purchase price must be positive")
    @ApiModelProperty(value = "The purchase price in the Baseprice", name = "bpPurchaseprice", dataType = "BigDecimal",
            required = true, example = "0")
    BigDecimal bpPurchaseprice;

    @NotNull(message = "The expected ristourne in the baseprice can't be null")
    @ApiModelProperty(value = "The expected ristourne in the Baseprice", name = "bpPurchaseprice",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal bpRistourne;

    @NotNull(message = "The expected semi whole price in the baseprice can't be null")
    @Positive(message = "The semi whole price must be positive")
    @ApiModelProperty(value = "The semi whole price in the Baseprice", name = "bpSemiwholesaleprice",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal bpSemiwholesaleprice;

    @NotNull(message = "The expected whole price in the baseprice can't be null")
    @Positive(message = "The whole price must be positive")
    @ApiModelProperty(value = "The whole price in the Baseprice", name = "bpWholesaleprice",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal bpWholesaleprice;

    @NotNull(message = "The id of the baseprice can't be null")
    @ApiModelProperty(value = "The Baseprice id", name = "id", dataType = "BigDecimal")
    Long id;


    public static BasepriceDto fromEntity(Baseprice entity){

        if(entity == null) return null;
        return BasepriceDto.builder()
                .bpCurrencyDto(CurrencyDto.fromEntity(entity.getBpCurrency()))
                .bpDetailprice(entity.getBpDetailprice())
                .bpPrecompte(entity.getBpPrecompte())
                .bpPurchaseprice(entity.getBpPurchaseprice())
                .bpRistourne(entity.getBpRistourne())
                .bpSemiwholesaleprice(entity.getBpSemiwholesaleprice())
                .bpWholesaleprice(entity.getBpWholesaleprice())
                .id(entity.getId())

                .build();
    }

    public static Baseprice  toEntity(BasepriceDto dto){

        if(dto == null) return null;
        Baseprice entity = new Baseprice();

        entity.setBpCurrency(CurrencyDto.toEntity(dto.getBpCurrencyDto()));
        entity.setBpDetailprice(dto.getBpDetailprice());
        entity.setBpPrecompte(dto.getBpPrecompte());
        entity.setBpPurchaseprice(dto.getBpPurchaseprice());
        entity.setBpRistourne(dto.getBpRistourne());
        entity.setBpSemiwholesaleprice(dto.getBpSemiwholesaleprice());
        entity.setBpWholesaleprice(dto.getBpWholesaleprice());
        entity.setId(dto.getId());

        return entity;
    }
}
