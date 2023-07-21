package com.c2psi.bm.dtos.stock.price;

import com.c2psi.bm.models.Specialprice;
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
public class SpecialpriceDto {

    @ApiModelProperty(value = "The Special price id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The base price associate to the special price can't be null")
    @ApiModelProperty(value = "The base price associate to the special price", name = "spBasepriceDto",
            dataType = "BasepriceDto")
    BasepriceDto spBasepriceDto;

    @NotNull(message = "The detail price of the special price can't be null")
    @Positive(message = "The detail price of special price must be positive value")
    @ApiModelProperty(value = "The detail price of the special price", name = "spDetailprice",
            dataType = "BigDecimal")
    BigDecimal spDetailprice;

    @NotNull(message = "The expected precompte of the special price can't be null")
    @ApiModelProperty(value = "The expected precompte of the special price", name = "spPrecompte",
            dataType = "BigDecimal")
    BigDecimal spPrecompte;

    @NotNull(message = "The expected ristourne of the special price can't be null")
    @ApiModelProperty(value = "The expected ristourne of the special price", name = "spRistourne",
            dataType = "BigDecimal")
    BigDecimal spRistourne;

    @NotNull(message = "The semi whole price of the special price can't be null")
    @Positive(message = "The semi whole price of special price must be positive value")
    @ApiModelProperty(value = "The semi whole price of the special price", name = "spSemiwholesaleprice",
            dataType = "BigDecimal")
    BigDecimal spSemiwholesaleprice;

    @NotNull(message = "The whole price of the special price can't be null")
    @Positive(message = "The whole price of special price must be positive value")
    @ApiModelProperty(value = "The whole price of the special price", name = "spWholesaleprice",
            dataType = "BigDecimal")
    BigDecimal spWholesaleprice;


    public static SpecialpriceDto fromEntity(Specialprice entity){

        if(entity == null) return null;
        return SpecialpriceDto.builder()
                .id(entity.getId())
                .spBasepriceDto(BasepriceDto.fromEntity(entity.getSpBaseprice()))
                .spDetailprice(entity.getSpDetailprice())
                .spPrecompte(entity.getSpPrecompte())
                .spRistourne(entity.getSpRistourne())
                .spSemiwholesaleprice(entity.getSpSemiwholesaleprice())
                .spWholesaleprice(entity.getSpWholesaleprice())

                .build();
    }

    public static Specialprice  toEntity(SpecialpriceDto dto){

        if(dto == null) return null;
        Specialprice entity = new Specialprice();

        entity.setId(dto.getId());
        entity.setSpBaseprice(BasepriceDto.toEntity(dto.getSpBasepriceDto()));
        entity.setSpDetailprice(dto.getSpDetailprice());
        entity.setSpPrecompte(dto.getSpPrecompte());
        entity.setSpRistourne(dto.getSpRistourne());
        entity.setSpSemiwholesaleprice(dto.getSpSemiwholesaleprice());
        entity.setSpWholesaleprice(dto.getSpWholesaleprice());

        return entity;
    }
}
