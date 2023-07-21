package com.c2psi.bm.dtos.stock.provider;

import com.c2psi.bm.dtos.AddressDto;
import com.c2psi.bm.models.Provider;
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
public class ProviderDto {
    @ApiModelProperty(value = "The Provider id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The pointofsale Provider id can't be null")
    @ApiModelProperty(value = "The pointofsale Provider id", name = "posProviderId", dataType = "Long")
    Long posProviderId;

    @ApiModelProperty(value = "The Provider address", name = "providerAddressDto", dataType = "AddressDto")
    AddressDto providerAddressDto;

    @NotNull(message = "The Provider cash account balance id can't be null")
    @ApiModelProperty(value = "The Provider cash account balance", name = "providerBalance", dataType = "BigDecimal",
            required = true, example = "0")
    BigDecimal providerBalance;

    @NotEmpty(message = "The Provider acronym can't be empty")
    @NotBlank(message = "The Provider acronym can't be blank")
    @Size(max = 10, message = "The Provider acronym size can't be above 10")
    @ApiModelProperty(value = "The Provider acronym", name = "providerAcronym", dataType = "String")
    String providerAcronym;

    @NotEmpty(message = "The Provider description can't be empty")
    @NotBlank(message = "The Provider description can't be blank")
    @Size(max = 100, message = "The Provider description size can't be above 100")
    @ApiModelProperty(value = "The Provider description", name = "providerDescription", dataType = "String")
    String providerDescription;

    @NotNull(message = "The Provider name can't be null")
    @NotEmpty(message = "The Provider name can't be empty")
    @NotBlank(message = "The Provider name can't be blank")
    @Size(max = 20, message = "The Provider name size can't be above 20")
    @ApiModelProperty(value = "The Provider name", name = "providerName", dataType = "String", required = true,
            example = "providerName")
    String providerName;


    public static ProviderDto fromEntity(Provider entity){

        if(entity == null) return null;
        return ProviderDto.builder()
                .id(entity.getId())
                .posProviderId(entity.getPosProviderId())
                .providerAddressDto(AddressDto.fromEntity(entity.getProviderAddress()))
                .providerBalance(entity.getProviderBalance())
                .providerAcronym(entity.getProviderAcronym())
                .providerDescription(entity.getProviderDescription())
                .providerName(entity.getProviderName())

                .build();
    }

    public static Provider  toEntity(ProviderDto dto){

        if(dto == null) return null;
        Provider entity = new Provider();

        entity.setId(dto.getId());
        entity.setPosProviderId(dto.getPosProviderId());
        entity.setProviderAddress(AddressDto.toEntity(dto.getProviderAddressDto()));
        entity.setProviderBalance(dto.getProviderBalance());
        entity.setProviderAcronym(dto.getProviderAcronym());
        entity.setProviderDescription(dto.getProviderDescription());
        entity.setProviderName(dto.getProviderName());

        return entity;
    }
}
