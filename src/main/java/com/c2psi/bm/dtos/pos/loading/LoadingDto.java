package com.c2psi.bm.dtos.pos.loading;


import com.c2psi.bm.models.Loading;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@ApiModel
public class LoadingDto {
    @ApiModelProperty(value = "The Loading id ", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The loading code can't be null")
    @NotEmpty(message = "The loading code can't be empty")
    @NotBlank(message = "The loading code can't be blank")
    @Size(max = 7, message = "The loading code size can't be above 10")
    @ApiModelProperty(value = "The Loading code ", name = "loadCode", dataType = "String", required = true,
            example = "LD_0000")
    String loadCode;

    //Where we can add an explanation of what happens during the saling session
    @NotEmpty(message = "The loading code can't be empty")
    @NotBlank(message = "The loading code can't be blank")
    @Size(max = 100, message = "The loading code size can't be above 100")
    @ApiModelProperty(value = "The Loading comment ", name = "loadComment", dataType = "String")
    String loadComment;

    @NotNull(message = "The loading date can't be null")
    @ApiModelProperty(value = "The Loading date ", name = "loadDate", dataType = "Instant")
    Instant loadDate;

    @NotNull(message = "The loading remise can't be null")
    @ApiModelProperty(value = "The Loading date ", name = "loadDate", dataType = "Instant")
    BigDecimal loadRemise;

    @NotEmpty(message = "The loading sale report can't be empty")
    @NotBlank(message = "The loading sale report can't be blank")
    @Size(max = 100, message = "The loading sale report size can't be above 100")
    @ApiModelProperty(value = "The Loading sale report ", name = "loadSalereport", dataType = "String")
    String loadSalereport;

    @NotNull(message = "The expected amount for the loading can't be null")
    @Positive(message = "The expected amount of a loading can't be negative or zero")
    @ApiModelProperty(value = "The amount expected for the loading ", name = "loadTotalamountexpected",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal loadTotalamountexpected;

    @NotNull(message = "The effective amount paid for the loading can't be null")
    @PositiveOrZero(message = "The amount effectively paid for the loading can't be negative")
    @ApiModelProperty(value = "The amount effectively paid for the loading ", name = "loadTotalamountpaid",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal loadTotalamountpaid;

    @NotNull(message = "The pointofsale id of the loading can't be null")
    @ApiModelProperty(value = "The pointofsale id of the loading ", name = "posLoadId",
            dataType = "Long", required = true, example = "0")
    Long posLoadId;


    public static LoadingDto fromEntity(Loading entity){
        if(entity == null) return null;
        return LoadingDto.builder()
                .id(entity.getId())
                .loadCode(entity.getLoadCode())
                .loadComment(entity.getLoadComment())
                .loadDate(entity.getLoadDate())
                .loadRemise(entity.getLoadRemise())
                .loadSalereport(entity.getLoadSalereport())
                .loadTotalamountexpected(entity.getLoadTotalamountexpected())
                .loadTotalamountpaid(entity.getLoadTotalamountpaid())
                .posLoadId(entity.getPosLoadId())

                .build();
    }

    public static Loading  toEntity(LoadingDto dto){
        if(dto == null) return null;
        Loading entity = new Loading();

        entity.setId(dto.getId());
        entity.setLoadCode(dto.getLoadCode());
        entity.setLoadComment(dto.getLoadComment());
        entity.setLoadDate(dto.getLoadDate());
        entity.setLoadRemise(dto.getLoadRemise());
        entity.setLoadSalereport(dto.getLoadSalereport());
        entity.setLoadTotalamountexpected(dto.getLoadTotalamountexpected());
        entity.setLoadTotalamountpaid(dto.getLoadTotalamountpaid());
        entity.setPosLoadId(dto.getPosLoadId());

        return entity;
    }
}
