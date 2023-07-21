package com.c2psi.bm.dtos.client.delivery;

import com.c2psi.bm.dtos.stock.provider.PackagingDto;
import com.c2psi.bm.models.DeliveryDetails;
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
public class DeliveryDetailsDto {
    @NotNull(message = "The Delivery associate with the DeliveryDetails can't be null")
    @ApiModelProperty(value = "The Delivery associate with the DeliveryDetails ", name = "ddDelivery",
            dataType = "DeliveryDto")
    DeliveryDto ddDelivery;

    @NotNull(message = "The number of packaging returned after delivery can't be null")
    @PositiveOrZero(message = "The number of packaging returned after delivery can't be negative value")
    @ApiModelProperty(value = "The number of packaging returned after delivery", name = "ddNumberofpackagereturn",
            dataType = "BigDecimal")
    BigDecimal ddNumberofpackagereturn;

    @NotNull(message = "The number of packaging used after delivery can't be null")
    @Positive(message = "The number of packaging used after delivery can't be negative nor zero")
    @ApiModelProperty(value = "The number of packaging used in the DeliveryDetails ", name = "ddNumberofpackageused",
            dataType = "BigDecimal", required = true, example = "1")
    BigDecimal ddNumberofpackageused;

    @NotNull(message = "The Packaging associate with the DeliveryDetails can't be null")
    @ApiModelProperty(value = "The Packaging used in the DeliveryDetails ", name = "ddPackaging",
            dataType = "PackagingDto")
    PackagingDto ddPackaging;

    @ApiModelProperty(value = "The DeliveruDetails id ", name = "id", dataType = "Long")
    Long id;
    public static DeliveryDetailsDto fromEntity(DeliveryDetails entity){
        if(entity == null) return null;
        return DeliveryDetailsDto.builder()
                .ddDelivery(DeliveryDto.fromEntity(entity.getDdDelivery()))
                .ddNumberofpackagereturn(entity.getDdNumberofpackagereturn())
                .ddNumberofpackageused(entity.getDdNumberofpackageused())
                .ddPackaging(PackagingDto.fromEntity(entity.getDdPackaging()))
                .id(entity.getId())

                .build();
    }

    public static DeliveryDetails toEntity(DeliveryDetailsDto dto){
        if(dto == null) return null;
        DeliveryDetails entity = new DeliveryDetails();

        entity.setDdDelivery(DeliveryDto.toEntity(dto.getDdDelivery()));
        entity.setDdNumberofpackagereturn(dto.getDdNumberofpackagereturn());
        entity.setDdNumberofpackageused(dto.getDdNumberofpackageused());
        entity.setDdPackaging(PackagingDto.toEntity(dto.getDdPackaging()));
        entity.setId(dto.getId());

        return entity;
    }
}
