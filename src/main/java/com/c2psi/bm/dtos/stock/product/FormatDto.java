package com.c2psi.bm.dtos.stock.product;


import com.c2psi.bm.models.Format;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class FormatDto {

    @NotNull(message = "The format capacity can't be null")
    @ApiModelProperty(value = "The capacity of the format", name = "formatCapacity", dataType = "BigDecimal")
    BigDecimal formatCapacity;

    @NotNull(message = "The format name can't be null")
    @NotEmpty(message = "The format name can't be empty")
    @NotBlank(message = "The format name can't be blank")
    @Size(max = 25, message = "The format name size can't be above 25")
    @ApiModelProperty(value = "The name of the format", name = "formatName", dataType = "String")
    String formatName;

    @ApiModelProperty(value = "The format id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The pointofsale id of the format can't be null")
    @ApiModelProperty(value = "The pointofsale id of the format", name = "posFormatId", dataType = "Long")
    Long posFormatId;

    public static FormatDto fromEntity(Format entity){

        if(entity == null) return null;
        return FormatDto.builder()
                .formatCapacity(entity.getFormatCapacity())
                .formatName(entity.getFormatName())
                .id(entity.getId())
                .posFormatId(entity.getPosFormatId())

                .build();
    }

    public static Format toEntity(FormatDto dto){
        if (dto == null) return null;
        Format entity = new Format();

        entity.setFormatCapacity(dto.getFormatCapacity());
        entity.setFormatName(dto.getFormatName());
        entity.setId(dto.getId());
        entity.setPosFormatId(dto.getPosFormatId());

        return entity;
    }
}
