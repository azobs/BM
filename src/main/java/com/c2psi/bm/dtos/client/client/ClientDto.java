package com.c2psi.bm.dtos.client.client;

import com.c2psi.bm.dtos.AddressDto;
import com.c2psi.bm.models.Client;
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
public class ClientDto {
    @ApiModelProperty(value = "The client Id", name = "id", dataType = "Long")
    Long id;
    @NotNull(message = "The client address cannot be null")
    @ApiModelProperty(value = "The client address", name = "addressDto", dataType = "AddressDto", required = true)
    AddressDto addressDto;
    @NotEmpty(message = "The client cni cannot be empty value")
    @NotBlank(message = "The client cni cannot be blank value")
    @Size(max = 9, message = "A client cni can't be above 9 characters ")
    @ApiModelProperty(value = "The cni number of the client", name = "clientCni", dataType = "String")
    String clientCni;
    @NotNull(message = "The client name cannot be null")
    @NotEmpty(message = "The client name cannot be empty value")
    @NotBlank(message = "The client name cannot be blank value")
    @Size(max = 25, message = "A client name can't be above 25 characters ")
    @ApiModelProperty(value = "The name of the client", name = "clientName", dataType = "String",
            example = "client name", required = true)
    String clientName;
    @NotEmpty(message = "The client othername cannot be empty value")
    @NotBlank(message = "The client othername cannot be blank value")
    @Size(max = 10, message = "A client othername can't be above 10 characters ")
    @ApiModelProperty(value = "Other name of the client", name = "clientOthername", dataType = "String")
    String clientOthername;
    @NotNull(message = "The account balance of the client can't be null")
    @ApiModelProperty(value = "The account balance of the client", name = "client balance", dataType = "BigDecimal",
            example = "0", required = true)
    BigDecimal clientBalance;
    @NotNull(message = "The pointofsale id of the client can't be null")
    @ApiModelProperty(value = "The pointofsale Id of the client", name = "posClientId", dataType = "String",
             required = true)
    Long posClientId;


    public static ClientDto fromEntity(Client entity){
        if(entity == null) return null;

        return ClientDto.builder()
                .addressDto(AddressDto.fromEntity(entity.getClientAddress()))
                .clientBalance(entity.getClientBalance())
                .clientCni(entity.getClientCni())
                .clientName(entity.getClientName())
                .clientOthername(entity.getClientOthername())
                .id(entity.getId())
                .posClientId(entity.getPosClientId())

                .build();
    }

    public static Client  toEntity(ClientDto dto){
        if(dto == null) return null;

        Client entity = new Client();
        entity.setClientAddress(AddressDto.toEntity(dto.getAddressDto()));
        entity.setClientBalance(dto.getClientBalance());
        entity.setClientCni(dto.getClientCni());
        entity.setClientName(dto.getClientName());
        entity.setClientOthername(dto.getClientOthername());
        entity.setId(dto.getId());
        entity.setPosClientId(dto.getPosClientId());

        return entity;
    }
}
