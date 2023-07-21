package com.c2psi.bm.dtos.client.client;

import com.c2psi.bm.dtos.stock.price.SpecialpriceDto;
import com.c2psi.bm.dtos.stock.product.ArticleDto;
import com.c2psi.bm.models.ClientSpecialprice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Builder
@ApiModel
public class ClientSpecialpriceDto {
    @NotNull(message = "The saving date can't be null")
    @ApiModelProperty(value = "The saving date of the clientspecialprice", name = "cltSpApplieddate",
            dataType = "Instant", required = true)
    Instant cltSpApplieddate;
    @NotNull(message = "The article in the clientspecialprice can't be null")
    @ApiModelProperty(value = "The article in the clientspecialprice", name = "cltSpArtDto",
            dataType = "ArticleDto", required = true)
    ArticleDto cltSpArtDto;
    @NotNull(message = "The client in the clientspecialprice can't be null")
    @ApiModelProperty(value = "The client in the clientspecialprice", name = "cltSpClientDto",
            dataType = "ClientDto", required = true)
    ClientDto cltSpClientDto;
    @NotNull(message = "The specialprice in the clientspecialprice can't be null")
    @ApiModelProperty(value = "The special price in the clientspecialprice", name = "cltSpSpDto",
            dataType = "SpecialpriceDto", required = true)
    SpecialpriceDto cltSpSpDto;
    @ApiModelProperty(value = "The client special price Id", name = "id", dataType = "Long")
    Long id;

    public static ClientSpecialpriceDto fromEntity(ClientSpecialprice entity){
        if(entity == null) return null;
        return ClientSpecialpriceDto.builder()
                .cltSpApplieddate(entity.getCltSpApplieddate())
                .cltSpArtDto(ArticleDto.fromEntity(entity.getCltSpArt()))
                .cltSpClientDto(ClientDto.fromEntity(entity.getCltSpClient()))
                .cltSpSpDto(SpecialpriceDto.fromEntity(entity.getCltSpSp()))
                .id(entity.getId())
                .build();
    }

    public static ClientSpecialprice toEntity(ClientSpecialpriceDto dto){
        if(dto == null) return null;

        ClientSpecialprice entity = new ClientSpecialprice();
        entity.setCltSpApplieddate(dto.getCltSpApplieddate());
        entity.setCltSpArt(ArticleDto.toEntity(dto.getCltSpArtDto()));
        entity.setCltSpClient(ClientDto.toEntity(dto.getCltSpClientDto()));
        entity.setCltSpSp(SpecialpriceDto.toEntity(dto.getCltSpSpDto()));
        entity.setId(dto.getId());

        return entity;
    }
}
