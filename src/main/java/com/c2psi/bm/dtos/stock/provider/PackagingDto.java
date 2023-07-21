package com.c2psi.bm.dtos.stock.provider;

import com.c2psi.bm.models.Packaging;
import com.c2psi.bm.models.Provider;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class PackagingDto {

    @ApiModelProperty(value = "The Packaging id", name = "id", dataType = "Long")
    Long id;

    @NotEmpty(message = "The Packaging description can't be empty")
    @NotBlank(message = "The Packaging description can't be blank")
    @Size(max = 100, message = "The Packaging description size can't be above 100")
    @ApiModelProperty(value = "The Packaging description", name = "packDescription", dataType = "String")
    String packDescription;

    @NotNull(message = "The Packaging first color can't be null")
    @NotEmpty(message = "The Packaging first color can't be empty")
    @NotBlank(message = "The Packaging first color can't be blank")
    @Size(max = 10, message = "The Packaging first color size can't be above 10")
    @ApiModelProperty(value = "The Packaging first color", name = "packFirstcolor", dataType = "String")
    String packFirstcolor;

    @NotNull(message = "The Packaging label can't be null")
    @NotEmpty(message = "The Packaging label can't be empty")
    @NotBlank(message = "The Packaging label can't be blank")
    @Size(max = 20, message = "The Packaging label size can't be above 20")
    @ApiModelProperty(value = "The Packaging label", name = "packLabel", dataType = "String")
    String packLabel;

    @NotNull(message = "The Pointofsale Packaging id can't be null")
    @ApiModelProperty(value = "The Pointofsale Packaging id", name = "posPackagingId", dataType = "Long")
    Long posPackagingId;

    @NotNull(message = "The Packaging price can't be null")
    @Positive(message = "The packaging price must be positive")
    @ApiModelProperty(value = "The Packaging price", name = "packPrice", dataType = "BigDecimal")
    BigDecimal packPrice;

    @NotNull(message = "The Packaging provider can't be null")
    @ApiModelProperty(value = "The provider of the Packaging", name = "packagingProviderDto", dataType = "ProviderDto")
    ProviderDto packagingProviderDto;


    public static PackagingDto fromEntity(Packaging entity){

        if(entity == null) return null;
        return PackagingDto.builder()
                .id(entity.getId())
                .packDescription(entity.getPackDescription())
                .packFirstcolor(entity.getPackFirstcolor())
                .packLabel(entity.getPackLabel())
                .posPackagingId(entity.getPosPackagingId())
                .packPrice(entity.getPackPrice())
                .packagingProviderDto(ProviderDto.fromEntity(entity.getPackagingProvider()))

                .build();
    }

    public static Packaging  toEntity(PackagingDto dto){

        if(dto == null) return null;
        Packaging entity = new Packaging();

        entity.setId(dto.getId());
        entity.setPackDescription(dto.getPackDescription());
        entity.setPackFirstcolor(dto.getPackFirstcolor());
        entity.setPackLabel(dto.getPackLabel());
        entity.setPosPackagingId(dto.getPosPackagingId());
        entity.setPackPrice(dto.getPackPrice());
        entity.setPackagingProvider(ProviderDto.toEntity(dto.getPackagingProviderDto()));

        return entity;
    }
}
