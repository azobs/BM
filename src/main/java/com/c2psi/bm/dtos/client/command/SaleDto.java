package com.c2psi.bm.dtos.client.command;


import com.c2psi.bm.dtos.stock.product.ArticleDto;
import com.c2psi.bm.enumerations.SaleType;
import com.c2psi.bm.models.Sale;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
@Data
@Builder
@ApiModel
public class SaleDto {
    @ApiModelProperty(value = "The Sale id ", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The Pointofsale id of the Sale can't be null")
    @ApiModelProperty(value = "The Pointofsale id of the Sale", name = "posSaleId", dataType = "Long", required = true,
                        example = "0")
    Long posSaleId;

    @NotNull(message = "The Article associate with the Sale can't be null")
    @ApiModelProperty(value = "The associate article of the Sale", name = "saleArticleDto", dataType = "ArticleDto",
            required = true)
    ArticleDto saleArticleDto;

    @NotNull(message = "The Command associate with the Sale can't be null")
    @ApiModelProperty(value = "The associate Command of the Sale", name = "saleCommandDto", dataType = "CommandDto",
            required = true)
    CommandDto saleCommandDto;

    @NotEmpty(message = "The comment associate to the Sale can't be empty value")
    @NotBlank(message = "The comment associate to the Sale can't be blank value")
    @Size(max = 100, message = "The comment associate to the Sale can't be above 100 characters ")
    @ApiModelProperty(value = "The Sale comment", name = "saleComment", dataType = "String")
    String saleComment;

    @NotNull(message = "The Final price of the Sale can't be null")
    @Positive(message = "The final price can't negative or zero")
    @ApiModelProperty(value = "The Final selling price", name = "saleFinalprice", dataType = "BigDecimal",
        required = true, example = "0")
    BigDecimal saleFinalprice;

    @NotNull(message = "The quantity associate with the Sale can't be null")
    @Positive(message = "The quantity in the sale can't be negative or zero")
    @ApiModelProperty(value = "The selling quantity", name = "saleQuantity", dataType = "BigDecimal",
            required = true, example = "1")
    BigDecimal saleQuantity;

    @NotNull(message = "The type of sale can't be null")
    @ApiModelProperty(value = "The selling type", name = "saleType", dataType = "String",
            required = true, allowableValues = "Details, Permutation, SemiWhole, Whole", example = "Whole")
    String saleType;


    public static SaleDto fromEntity(Sale entity){
        if(entity == null) return null;
        return SaleDto.builder()
                .id(entity.getId())
                .posSaleId(entity.getPosSaleId())
                .saleArticleDto(ArticleDto.fromEntity(entity.getSaleArticle()))
                .saleCommandDto(CommandDto.fromEntity(entity.getSaleCommand()))
                .saleComment(entity.getSaleComment())
                .saleFinalprice(entity.getSaleFinalprice())
                .saleQuantity(entity.getSaleQuantity())
                .saleType(entity.getSaleType().name())
                .build();
    }

    public static Sale toEntity(SaleDto dto){
        if(dto == null) return null;
        Sale entity = new Sale();

        entity.setId(dto.getId());
        entity.setPosSaleId(dto.getPosSaleId());
        entity.setSaleArticle(ArticleDto.toEntity(dto.getSaleArticleDto()));
        entity.setSaleCommand(CommandDto.toEntity(dto.getSaleCommandDto()));
        entity.setSaleComment(dto.getSaleComment());
        entity.setSaleFinalprice(dto.getSaleFinalprice());
        entity.setSaleFinalprice(dto.getSaleFinalprice());
        entity.setSaleQuantity(dto.getSaleQuantity());
        entity.setSaleType(
                dto.getSaleType().equalsIgnoreCase(SaleType.Details.name()) ? SaleType.Details :
                dto.getSaleType().equalsIgnoreCase(SaleType.Permutation.name()) ? SaleType.Permutation :
                dto.getSaleType().equalsIgnoreCase(SaleType.SemiWhole.name()) ? SaleType.SemiWhole : SaleType.Whole
        );

        return entity;
    }
}
