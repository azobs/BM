package com.c2psi.bm.dtos.stock.product;


import com.c2psi.bm.models.InventoryLine;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class InventoryLineDto {
    @ApiModelProperty(value = "The Inventory line id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The Article associate to the Inventory line can't be null")
    @ApiModelProperty(value = "The Article associate to the Inventory line", name = "invlineArtDto",
            dataType = "ArticleDto")
    ArticleDto invlineArtDto;

    @NotEmpty(message = "The comment associate to the inventory line can't be empty")
    @NotBlank(message = "The comment associate to the inventory line can't be blank")
    @Size(max = 100, message = "The comment associate to the inventory line size can't be above 100")
    @ApiModelProperty(value = "The comment of the Inventory line", name = "invlineComment", dataType = "String")
    String invlineComment;

    @NotNull(message = "The Inventory associate to the Inventory line can't be null")
    @ApiModelProperty(value = "The Inventory associate to the Inventory line", name = "invlineInvDto",
            dataType = "InventoryDto")
    InventoryDto invlineInvDto;

    @NotNull(message = "The logic quantity that is suppose to be in stock can't be null")
    @PositiveOrZero(message = "The logic quantity can't be negetive")
    @ApiModelProperty(value = "The logic quantity that is suppose to be in stock", name = "invlineLogicqteinstock",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal invlineLogicqteinstock;

    @NotNull(message = "The real quantity that is suppose to be in stock can't be null")
    @PositiveOrZero(message = "The real quantity can't be negetive")
    @ApiModelProperty(value = "The real quantity in stock", name = "invlineRealqteinstock",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal invlineRealqteinstock;


    public static InventoryLineDto fromEntity(InventoryLine entity){

        if(entity == null) return null;
        return InventoryLineDto.builder()
                .id(entity.getId())
                .invlineArtDto(ArticleDto.fromEntity(entity.getInvlineArt()))
                .invlineComment(entity.getInvlineComment())
                .invlineInvDto(InventoryDto.fromEntity(entity.getInvlineInv()))
                .invlineLogicqteinstock(entity.getInvlineLogicqteinstock())
                .invlineRealqteinstock(entity.getInvlineRealqteinstock())

                .build();
    }

    public static InventoryLine  toEntity(InventoryLineDto dto){

        if(dto == null) return null;
        InventoryLine entity = new InventoryLine();

        entity.setId(dto.getId());
        entity.setInvlineArt(ArticleDto.toEntity(dto.getInvlineArtDto()));
        entity.setInvlineComment(dto.getInvlineComment());
        entity.setInvlineInv(InventoryDto.toEntity(dto.getInvlineInvDto()));
        entity.setInvlineLogicqteinstock(dto.getInvlineLogicqteinstock());
        entity.setInvlineRealqteinstock(dto.getInvlineRealqteinstock());

        return entity;
    }
}
