package com.c2psi.bm.dtos.stock.product;

import com.c2psi.bm.models.Product;
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
public class ProductDto {
    @ApiModelProperty(value = "The product id", name = "id", dataType = "Long")
    Long id;

    @NotEmpty(message = "The product name alias can't be empty")
    @NotBlank(message = "The product name alias can't be blank")
    @Size(max = 15, message = "The product name alias size can't be above 15")
    @ApiModelProperty(value = "The product name alias", name = "prodAlias", dataType = "String")
    String prodAlias;

    @NotNull(message = "The product category can't be null")
    @ApiModelProperty(value = "The product category", name = "prodCatDto", dataType = "CategoryDto")
    CategoryDto prodCatDto;

    @NotNull(message = "The product code can't be null")
    @NotEmpty(message = "The product code alias can't be empty")
    @NotBlank(message = "The product code alias can't be blank")
    @Size(max = 10, message = "The product code alias size can't be above 10")
    @ApiModelProperty(value = "The product code", name = "prodCode", dataType = "String", required = true,
        example = "Prod_0000")
    String prodCode;

    @NotEmpty(message = "The product description can't be empty")
    @NotBlank(message = "The product description can't be blank")
    @Size(max = 100, message = "The product description size can't be above 100")
    @ApiModelProperty(value = "The product description", name = "prodDescription", dataType = "String")
    String prodDescription;

    @NotNull(message = "The product name can't be null")
    @NotEmpty(message = "The product name can't be empty")
    @NotBlank(message = "The product name can't be blank")
    @Size(max = 25, message = "The product name size can't be above 25")
    @ApiModelProperty(value = "The product name", name = "prodName", dataType = "String",
            required = true, example = "ProdName")
    String prodName;

    @ApiModelProperty(value = "The product perichable", name = "prodPerishable", dataType = "Boolean")
    Boolean prodPerishable;

    @NotNull(message = "The pointofsale id of the product can't be null")
    @ApiModelProperty(value = "The pointofsale id of the product", name = "posProdId", dataType = "Long",
            required = true, example = "0")
    Long posProdId;


    public static ProductDto fromEntity(Product entity){

        if(entity == null) return null;
        return ProductDto.builder()
                .id(entity.getPosProdId())
                .prodAlias(entity.getProdAlias())
                .prodCatDto(CategoryDto.fromEntity(entity.getProdCat()))
                .prodCode(entity.getProdCode())
                .prodDescription(entity.getProdDescription())
                .prodName(entity.getProdName())
                .prodPerishable(entity.getProdPerishable())
                .posProdId(entity.getPosProdId())

                .build();
    }

    public static Product  toEntity(ProductDto dto){

        if(dto == null) return null;
        Product entity = new Product();

        entity.setId(dto.getId());
        entity.setProdAlias(dto.getProdAlias());
        entity.setProdCat(CategoryDto.toEntity(dto.getProdCatDto()));
        entity.setProdCode(dto.getProdCode());
        entity.setProdDescription(dto.getProdDescription());
        entity.setProdName(dto.getProdName());
        entity.setProdPerishable(dto.getProdPerishable());
        entity.setPosProdId(dto.getPosProdId());

        return entity;
    }
}
