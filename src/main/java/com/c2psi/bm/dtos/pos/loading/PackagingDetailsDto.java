package com.c2psi.bm.dtos.pos.loading;


import com.c2psi.bm.dtos.stock.provider.PackagingDto;
import com.c2psi.bm.models.PackagingDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class PackagingDetailsDto {
    @ApiModelProperty(value = "The PackagingDetails id ", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The loading associate to the PackagingDetails can't be null")
    @ApiModelProperty(value = "The Loading associate to the PackagingDetails ", name = "pdLoadingDto",
            dataType = "LoadingDto")
    LoadingDto pdLoadingDto;

    @NotNull(message = "The number of packaging returned in the PackagingDetails can't be null")
    @PositiveOrZero(message = "The number of packaging returned can't be negative")
    @ApiModelProperty(value = "The number of packaging returned in the PackagingDetails ", name = "pdNumberofpackagereturn",
            dataType = "BigDecimal")
    BigDecimal pdNumberofpackagereturn;

    @NotNull(message = "The number of packaging used in the PackagingDetails can't be null")
    @Positive(message = "The number of packaging returned must be positive")
    @ApiModelProperty(value = "The number of packaging used in the PackagingDetails ", name = "pdNumberofpackageused",
            dataType = "BigDecimal")
    BigDecimal pdNumberofpackageused;

    @NotNull(message = "The number of packaging returned in the PackagingDetails can't be null")
    @ApiModelProperty(value = "The Packaging associate to the PackagingDetails ", name = "pdPackagingDto",
            dataType = "PackagingDto")
    PackagingDto pdPackagingDto;


    public static PackagingDetailsDto fromEntity(PackagingDetails entity){

        if(entity == null) return null;
        return PackagingDetailsDto.builder()
                .id(entity.getId())
                .pdLoadingDto(LoadingDto.fromEntity(entity.getPdLoading()))
                .pdNumberofpackagereturn(entity.getPdNumberofpackagereturn())
                .pdNumberofpackageused(entity.getPdNumberofpackageused())
                .pdPackagingDto(PackagingDto.fromEntity(entity.getPdPackaging()))

                .build();
    }

    public static PackagingDetails  toEntity(PackagingDetailsDto dto){

        if(dto == null) return null;
        PackagingDetails entity = new PackagingDetails();

        entity.setId(dto.getId());
        entity.setPdLoading(LoadingDto.toEntity(dto.getPdLoadingDto()));
        entity.setPdNumberofpackagereturn(dto.getPdNumberofpackagereturn());
        entity.setPdNumberofpackageused(dto.getPdNumberofpackageused());
        entity.setPdPackaging(PackagingDto.toEntity(dto.getPdPackagingDto()));

        return entity;
    }
}
