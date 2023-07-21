package com.c2psi.bm.dtos.stock.product;


import com.c2psi.bm.models.Inventory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.Instant;

@Data
@Builder
@ApiModel
public class InventoryDto {
    @NotNull(message = "The inventory id can't be null")
    @ApiModelProperty(value = "The Inventory id", name = "id", dataType = "Long")
    Long id;

    @NotEmpty(message = "The Inventory comment can't be empty")
    @NotBlank(message = "The Inventory comment can't be blank")
    @Size(max = 256, message = "The Inventory comment size can't be above 256")
    @ApiModelProperty(value = "The Inventory comment", name = "invComment", dataType = "String")
    String invComment;

    @NotNull(message = "The inventory code can't be null")
    @NotEmpty(message = "The Inventory code can't be empty")
    @NotBlank(message = "The Inventory code can't be blank")
    @Size(max = 10, message = "The Inventory comment size can't be above 10")
    @ApiModelProperty(value = "The Inventory code", name = "invCode", dataType = "String", required = true,
            example = "inv_0000")
    String invCode;

    @NotNull(message = "The inventory date can't be null")
    @PastOrPresent(message = "The inventory date can't be in the future")
    @ApiModelProperty(value = "The Inventory date", name = "invDate", dataType = "Instant")
    Instant invDate;

    @NotNull(message = "The pointofsale id can't be null")
    @ApiModelProperty(value = "The Pointofsale id of the inventory", name = "posInvId", dataType = "Long",
            required = true, example = "0")
    Long posInvId;


    public static InventoryDto fromEntity(Inventory entity){

        if(entity == null) return null;
        return InventoryDto.builder()
                .id(entity.getId())
                .invComment(entity.getInvComment())
                .invCode(entity.getInvCode())
                .invDate(entity.getInvDate())
                .posInvId(entity.getPosInvId())

                .build();
    }

    public static Inventory  toEntity(InventoryDto dto){

        if(dto == null) return null;
        Inventory entity = new Inventory();

        entity.setId(dto.getId());
        entity.setInvComment(dto.getInvComment());
        entity.setInvCode(dto.getInvCode());
        entity.setInvDate(dto.getInvDate());
        entity.setPosInvId(dto.getPosInvId());

        return entity;
    }
}
