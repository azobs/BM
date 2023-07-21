package com.c2psi.bm.dtos.stock.product;


import com.c2psi.bm.models.Category;
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
public class CategoryDto {
    @NotNull(message = "The category code can't be null")
    @NotEmpty(message = "The category code can't be empty")
    @NotBlank(message = "The category code can't be blank")
    @Size(max = 10, message = "The category code size can't be above 10")
    @ApiModelProperty(value = "The category code", name = "catCode", dataType = "String", required = true,
            example = "cat_0000")
    String catCode;

    @NotEmpty(message = "The category description can't be empty")
    @NotBlank(message = "The category description can't be blank")
    @Size(max = 50, message = "The category description size can't be above 50")
    @ApiModelProperty(value = "The category description", name = "catDescription", dataType = "String")
    String catDescription;

    @NotNull(message = "The category name can't be null")
    @NotEmpty(message = "The category name can't be empty")
    @NotBlank(message = "The category name can't be blank")
    @Size(max = 20, message = "The category name size can't be above 20")
    @ApiModelProperty(value = "The category name", name = "catName", dataType = "String", required = true,
            example = "catName")
    String catName;

    @ApiModelProperty(value = "The category parent id", name = "catParentId", dataType = "Long")
    Long catParentId;

    @NotEmpty(message = "The category shortname can't be empty")
    @NotBlank(message = "The category shortname can't be blank")
    @Size(max = 15, message = "The category shortname size can't be above 15")
    @ApiModelProperty(value = "The category shortname", name = "catShortname", dataType = "String")
    String catShortname;

    @ApiModelProperty(value = "The category id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The pointofsale id of the category can't be null")
    @ApiModelProperty(value = "The pointofsale id of the category", name = "posCatId", dataType = "Long")
    Long posCatId;


    public static CategoryDto fromEntity(Category entity){

        if(entity == null) return null;
        return CategoryDto.builder()
                .catCode(entity.getCatCode())
                .catDescription(entity.getCatDescription())
                .catName(entity.getCatName())
                .catParentId(entity.getPosCatId())
                .catShortname(entity.getCatShortname())
                .id(entity.getId())
                .posCatId(entity.getPosCatId())

                .build();
    }

    public static Category  toEntity(CategoryDto dto){

        if(dto == null) return null;
        Category entity = new Category();

        entity.setCatCode(dto.getCatCode());
        entity.setCatDescription(dto.getCatDescription());
        entity.setCatName(dto.getCatName());
        entity.setCatParentId(dto.getCatParentId());
        entity.setCatShortname(dto.getCatShortname());
        entity.setId(dto.getId());
        entity.setPosCatId(dto.getPosCatId());

        return entity;
    }
}
