package com.c2psi.bm.dtos.stock.provider;


import com.c2psi.bm.dtos.stock.product.ArticleDto;
import com.c2psi.bm.models.ProviderAccount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class ProviderAccountDto {
    @ApiModelProperty(value = "The provider account id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The article associate to the provider account can't be null")
    @ApiModelProperty(value = "The article associate to the provider account", name = "proaArticleDto",
            dataType = "ArticleDto")
    ArticleDto proaArticleDto;

    @NotNull(message = "The provider associate to the provider account can't be null")
    @ApiModelProperty(value = "The provider associate to the provider account", name = "proaProviderDto",
            dataType = "ProviderDto")
    ProviderDto proaProviderDto;

    @NotNull(message = "The packaging associate to the provider account can't be null")
    @ApiModelProperty(value = "The packaging associate to the provider account", name = "proaPackagingDto",
            dataType = "PackagingDto")
    PackagingDto proaPackagingDto;

    @ApiModelProperty(value = "The total number of capsule in the provider account", name = "providerNumberofCapsule",
            dataType = "BigDecimal")
    BigDecimal providerNumberofCapsule;

    @ApiModelProperty(value = "The total number of damage in the provider account", name = "providerNumberofDamage",
            dataType = "BigDecimal")
    BigDecimal providerNumberofDamage;

    @ApiModelProperty(value = "The total number of packaging in the provider account", name = "providerNumberofPackaging",
            dataType = "BigDecimal")
    BigDecimal providerNumberofPackaging;


    public static ProviderAccountDto fromEntity(ProviderAccount entity){

        if(entity == null) return null;
        return ProviderAccountDto.builder()
                .id(entity.getId())
                .proaArticleDto(ArticleDto.fromEntity(entity.getProaArticle()))
                .proaProviderDto(ProviderDto.fromEntity(entity.getProaProvider()))
                .proaPackagingDto(PackagingDto.fromEntity(entity.getProaPackaging()))
                .providerNumberofCapsule(entity.getProviderNumberofCapsule())
                .providerNumberofDamage(entity.getProviderNumberofDamage())
                .providerNumberofPackaging(entity.getProviderNumberofPackaging())

                .build();

    }

    public static ProviderAccount  toEntity(ProviderAccountDto dto){

        if(dto == null) return null;
        ProviderAccount entity = new ProviderAccount();

        entity.setId(dto.getId());
        entity.setProaArticle(ArticleDto.toEntity(dto.getProaArticleDto()));
        entity.setProaProvider(ProviderDto.toEntity(dto.getProaProviderDto()));
        entity.setProaPackaging(PackagingDto.toEntity(dto.getProaPackagingDto()));
        entity.setProviderNumberofCapsule(dto.getProviderNumberofCapsule());
        entity.setProviderNumberofDamage(dto.getProviderNumberofDamage());
        entity.setProviderNumberofPackaging(dto.getProviderNumberofPackaging());

        return entity;
    }
}
