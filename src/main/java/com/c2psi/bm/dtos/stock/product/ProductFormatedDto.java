package com.c2psi.bm.dtos.stock.product;

import com.c2psi.bm.models.ProductFormated;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ApiModel
public class ProductFormatedDto {

    @ApiModelProperty(value = "The ProductFormated id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The Format associate to the productformated can't be null")
    @ApiModelProperty(value = "The Format associate to the productFormated", name = "pfFormatDto",
            dataType = "FormatDto")
    FormatDto pfFormatDto;

    @ApiModelProperty(value = "The picture that illustrate the productFormated", name = "pfPicture",
            dataType = "String")
    String pfPicture;

    @NotNull(message = "The product associate to the productformated can't be null")
    @ApiModelProperty(value = "The Product associate to the productFormated", name = "pfProductDto",
            dataType = "ProductDto")
    ProductDto pfProductDto;

    public static ProductFormatedDto fromEntity(ProductFormated entity){

        if(entity == null) return null;
        return ProductFormatedDto.builder()
                .id(entity.getId())
                .pfFormatDto(FormatDto.fromEntity(entity.getPfFormat()))
                .pfPicture(entity.getPfPicture())
                .pfProductDto(ProductDto.fromEntity(entity.getPfProduct()))

                .build();
    }

    public static ProductFormated  toEntity(ProductFormatedDto dto){

        if(dto == null) return null;
        ProductFormated entity = new ProductFormated();

        entity.setId(dto.getId());
        entity.setPfFormat(FormatDto.toEntity(dto.getPfFormatDto()));
        entity.setPfPicture(dto.getPfPicture());
        entity.setPfProduct(ProductDto.toEntity(dto.getPfProductDto()));

        return entity;
    }
}
