package com.c2psi.bm.dtos.client.command;

import com.c2psi.bm.dtos.stock.product.ArticleDto;
import com.c2psi.bm.models.BackInDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
@Data
@Builder
@ApiModel
public class BackInDetailsDto {
    @NotNull(message = "The article associate with the BackInDetails can't be null")
    @ApiModelProperty(value = "The article associe with the BackInDetails", name = "bidArticle",
            dataType = "ArticleDto", required = true)
    ArticleDto bidArticleDto;
    @NotEmpty(message = "The comment associate to the BackInDetails can't be empty value")
    @NotBlank(message = "The comment associate to the BackInDetails can't be blank value")
    @Size(max = 100, message = "The comment associate to the BackInDetails can't be above 100 characters ")
    @ApiModelProperty(value = "The quantity return for the article", name = "bidComment", dataType = "String")
    String bidComment;
    @NotNull(message = "The BackIn associate with the BackInDetails can't be null")
    @ApiModelProperty(value = "The backIn associate with the BackInDetails", name = "bidbi",
            dataType = "BackInDto", required = true)
    BackInDto bidbiDto;
    @NotNull(message = "The quantity in the BackInDetails can't be null")
    @PositiveOrZero(message = "The quantity return can't be negative")
    @ApiModelProperty(value = "The quantity return for the article", name = "bidQuantity",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal bidQuantity;
    @ApiModelProperty(value = "The id of the BackInDetails", name = "id", dataType = "Long")
    Long id;

    public static BackInDetailsDto fromEntity(BackInDetails entity){
        if(entity == null) return null;
        return BackInDetailsDto.builder()
                .bidArticleDto(ArticleDto.fromEntity(entity.getBidArticle()))
                .bidComment(entity.getBidComment())
                .bidbiDto(BackInDto.fromEntity(entity.getBidbi()))
                .bidQuantity(entity.getBidQuantity())
                .id(entity.getId())
                .build();
    }

    public static BackInDetails toEntity(BackInDetailsDto dto){
        if(dto == null) return null;
        BackInDetails entity = new BackInDetails();
        entity.setBidArticle(ArticleDto.toEntity(dto.getBidArticleDto()));
        entity.setBidComment(dto.getBidComment());
        entity.setBidbi(BackInDto.toEntity(dto.getBidbiDto()));
        entity.setBidQuantity(dto.getBidQuantity());
        entity.setId(dto.getId());
        return entity;
    }
}
