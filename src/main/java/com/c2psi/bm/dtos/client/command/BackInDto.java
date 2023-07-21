package com.c2psi.bm.dtos.client.command;


import com.c2psi.bm.dtos.pos.userbm.UserBMDto;
import com.c2psi.bm.models.BackIn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.Instant;

@Data
@Builder
@ApiModel
public class BackInDto {
    @NotNull(message = "The command associate with the BackIn can't be null")
    @ApiModelProperty(value = "The Command associate with the BackIn", name = "biCommandDto",
            dataType = "CommandDto", required = true)
    CommandDto biCommandDto;
    @NotEmpty(message = "The comment associate to the BackIn can't be empty value")
    @NotBlank(message = "The comment associate to the BackIn can't be blank value")
    @Size(max = 100, message = "The comment associate to the BackIn can't be above 100 characters ")
    @ApiModelProperty(value = "The comment associate with the BackIn", name = "biComment", dataType = "String")
    String biComment;
    @NotNull(message = "The date of the BackIn can't be null")
    @PastOrPresent(message = "The date of the BackIn can't be in the future")
    @ApiModelProperty(value = "The saving date of the BackIn", name = "biDate",
            dataType = "Instant", required = true)
    Instant biDate;
    @NotNull(message = "The userBM associate with the BackIn can't be null")
    @ApiModelProperty(value = "The UserBM that register the BackIn", name = "biUserbmDto",
            dataType = "UserBMDto", required = true)
    UserBMDto biUserbmDto;
    @ApiModelProperty(value = "The id of the BackIn", name = "id", dataType = "Long")
    Long id;
    @NotNull(message = "The id of the pointofsale can't be null")
    @ApiModelProperty(value = "The id of the pointofsale in which the BackIn is", name = "posBiId", dataType = "Long")
    Long posBiId;

    public static BackInDto fromEntity(BackIn entity){
        if(entity == null) return null;
        return BackInDto.builder()
                .biCommandDto(CommandDto.fromEntity(entity.getBiCommand()))
                .biComment(entity.getBiComment())
                .biDate(entity.getBiDate())
                .biUserbmDto(UserBMDto.fromEntity(entity.getBiUserbm()))
                .id(entity.getId())
                .posBiId(entity.getPosBiId())

                .build();
    }

    public static BackIn  toEntity(BackInDto dto){
        if(dto == null) return null;
        BackIn entity = new BackIn();
        entity.setBiCommand(CommandDto.toEntity(dto.getBiCommandDto()));
        entity.setBiComment(dto.getBiComment());
        entity.setBiDate(dto.getBiDate());
        entity.setBiUserbm(UserBMDto.toEntity(dto.getBiUserbmDto()));
        entity.setId(dto.getId());
        entity.setPosBiId(entity.getPosBiId());

        return entity;
    }
}
