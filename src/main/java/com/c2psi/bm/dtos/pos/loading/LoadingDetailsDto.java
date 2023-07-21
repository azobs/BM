package com.c2psi.bm.dtos.pos.loading;


import com.c2psi.bm.dtos.stock.product.ArticleDto;
import com.c2psi.bm.models.LoadingDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
@Data
@Builder
@ApiModel
public class LoadingDetailsDto {
    @ApiModelProperty(value = "The LoadingDetails id ", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The Article associate to the LoadingDetails can't be null")
    @ApiModelProperty(value = "The Article indicated in the LoadingDetails ", name = "ldArticleDto",
            dataType = "ArticleDto")
    ArticleDto ldArticleDto;

    @NotNull(message = "The Loading associate to the LoadingDetails can't be null")
    @ApiModelProperty(value = "The Loading indicated in the LoadingDetails ", name = "ldLoadingDto",
            dataType = "LoadingDto")
    LoadingDto ldLoadingDto;

    @NotNull(message = "The quantity return precised by the LoadingDetails can't be null")
    @PositiveOrZero(message = "The quantity return precised by the LoadingDetails can't be negative")
    @ApiModelProperty(value = "The quantity return precised by the LoadingDetails ", name = "ldQuantityreturn",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal ldQuantityreturn;

    @NotNull(message = "The quantity taken precised by the LoadingDetails can't be null")
    @Positive(message = "The quantity taken must be positive")
    @ApiModelProperty(value = "The quantity taken precised by the LoadingDetails ", name = "ldQuantitytaken",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal ldQuantitytaken;


    public static LoadingDetailsDto fromEntity(LoadingDetails entity){
        if(entity == null) return null;
        return LoadingDetailsDto.builder()
                .id(entity.getId())
                .ldArticleDto(ArticleDto.fromEntity(entity.getLdArticle()))
                .ldLoadingDto(LoadingDto.fromEntity(entity.getLdLoading()))
                .ldQuantityreturn(entity.getLdQuantityreturn())
                .ldQuantitytaken(entity.getLdQuantitytaken())

                .build();
    }

    public static LoadingDetails  toEntity(LoadingDetailsDto dto){
        if(dto == null) return null;
        LoadingDetails entity = new LoadingDetails();

        entity.setId(dto.getId());
        entity.setLdArticle(ArticleDto.toEntity(dto.getLdArticleDto()));
        entity.setLdLoading(LoadingDto.toEntity(dto.getLdLoadingDto()));
        entity.setLdQuantityreturn(dto.getLdQuantityreturn());
        entity.setLdQuantitytaken(dto.getLdQuantitytaken());

        return entity;
    }
}
