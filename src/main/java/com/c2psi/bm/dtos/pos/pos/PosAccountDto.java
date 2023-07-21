package com.c2psi.bm.dtos.pos.pos;


import com.c2psi.bm.dtos.stock.product.ArticleDto;
import com.c2psi.bm.dtos.stock.provider.PackagingDto;
import com.c2psi.bm.models.PosAccount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class PosAccountDto {
    @ApiModelProperty(value = "The PosAccount Id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The article associate with the PosAccont can't be null")
    @ApiModelProperty(value = "The Article associate with the PosAccount", name = "paArticleDto",
            dataType = "ArticleDto")
    ArticleDto paArticleDto;

    @ApiModelProperty(value = "The number of capsule in the the PosAccount concerning the article",
            name = "paNumberofCapsule", dataType = "BigDecimal")
    BigDecimal paNumberofCapsule;

    @ApiModelProperty(value = "The number of damage in the the PosAccount concerning the article",
            name = "paNumberofDamage", dataType = "BigDecimal")
    BigDecimal paNumberofDamage;

    @ApiModelProperty(value = "The number of packaging in the the PosAccount concerning the Packaging",
            name = "paNumberofPackaging", dataType = "BigDecimal")
    BigDecimal paNumberofPackaging;

    @NotNull(message = "The Pointofsale associate with the PosAccont can't be null")
    @ApiModelProperty(value = "The pointofsale associate with the PosAccount", name = "paPosDto",
            dataType = "PointofsaleDto")
    PointofsaleDto paPosDto;

    @NotNull(message = "The Packaging associate with the PosAccont can't be null")
    @ApiModelProperty(value = "The Packaging associate with the PosAccount", name = "paPackagingDto",
            dataType = "PackagingDto")
    PackagingDto paPackagingDto;


    public static PosAccountDto fromEntity(PosAccount entity){

        if(entity == null) return null;
        return PosAccountDto.builder()
                .id(entity.getId())
                .paArticleDto(ArticleDto.fromEntity(entity.getPaArticle()))
                .paNumberofCapsule(entity.getPaNumberofCapsule())
                .paNumberofDamage(entity.getPaNumberofDamage())
                .paNumberofPackaging(entity.getPaNumberofPackaging())
                .paPosDto(PointofsaleDto.fromEntity(entity.getPaPos()))
                .paPackagingDto(PackagingDto.fromEntity(entity.getPaPackaging()))

                .build();
    }

    public static PosAccount  toEntity(PosAccountDto dto){

        if(dto == null) return null;
        PosAccount entity = new PosAccount();

        entity.setId(dto.getId());
        entity.setPaArticle(ArticleDto.toEntity(dto.getPaArticleDto()));
        entity.setPaNumberofCapsule(dto.getPaNumberofCapsule());
        entity.setPaNumberofDamage(dto.getPaNumberofDamage());
        entity.setPaNumberofPackaging(dto.getPaNumberofPackaging());
        entity.setPaPos(PointofsaleDto.toEntity(dto.getPaPosDto()));
        entity.setPaPackaging(PackagingDto.toEntity(dto.getPaPackagingDto()));

        return entity;
    }
}
