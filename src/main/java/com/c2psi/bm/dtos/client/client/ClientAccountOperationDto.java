package com.c2psi.bm.dtos.client.client;

import com.c2psi.bm.dtos.OperationDto;
import com.c2psi.bm.models.ClientAccountOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
@Data
@Builder
@ApiModel
public class ClientAccountOperationDto {
    @ApiModelProperty(value = "id of client operation", name = "id", dataType = "Long")
    Long id;
    @NotNull(message = "The associate operation can't be null")
    @ApiModelProperty(value = "The associate operation", name = "caoOperationDto", dataType = "OperationDto", required = true)
    OperationDto caoOperationDto;
    @NotNull(message = "The number in mouvement in the operation can't be null")
    @Positive(message = "The number in mouvement in the operation must be positive")
    @ApiModelProperty(value = "The number in mvt", name = "caoNumberinmvt", dataType = "BigDecimal", required = true)
    BigDecimal caoNumberinmvt;
    @NotNull(message = "The client account associate with the operation can't be null")
    @ApiModelProperty(value = "The client account associate with the operation", name = "caoClientAccountDto",
            dataType = "caoClientAccountDto", required = true)
    ClientAccountDto caoClientAccountDto;


    public static ClientAccountOperationDto fromEntity(ClientAccountOperation entity){
        if(entity == null) return null;
        return ClientAccountOperationDto.builder()
                .caoClientAccountDto(ClientAccountDto.fromEntity(entity.getCaoClientAccount()))
                .id(entity.getId())
                .caoNumberinmvt(entity.getCaoNumberinmvt())
                .caoOperationDto(OperationDto.fromEntity(entity.getCaoOperation()))

                .build();
    }

    public static ClientAccountOperation  toEntity(ClientAccountOperationDto dto){
        if(dto == null) return null;
        ClientAccountOperation clientAccountOperation = new ClientAccountOperation();
        clientAccountOperation.setCaoClientAccount(ClientAccountDto.toEntity(dto.getCaoClientAccountDto()));
        clientAccountOperation.setId(dto.getId());
        clientAccountOperation.setCaoNumberinmvt(dto.getCaoNumberinmvt());
        clientAccountOperation.setCaoOperation(OperationDto.toEntity(dto.getCaoOperationDto()));

        return clientAccountOperation;
    }
}
