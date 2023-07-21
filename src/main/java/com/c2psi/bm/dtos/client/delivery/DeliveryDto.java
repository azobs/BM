package com.c2psi.bm.dtos.client.delivery;

import com.c2psi.bm.dtos.pos.userbm.UserBMDto;
import com.c2psi.bm.enumerations.DeliveryState;
import com.c2psi.bm.models.Delivery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.Instant;

@Data
@Builder
@ApiModel
public class DeliveryDto {
    @NotNull(message = "The Delivery code can't be null")
    @NotEmpty(message = "The Delivery code can't be empty")
    @NotBlank(message = "The Delivery code can't be blank")
    @Size(max =7, message = "The delivery code size can't be above 10")
    @ApiModelProperty(value = "The Delivery code ", name = "deliveryCode", dataType = "String",
            required = true, example = "DE_0000")
    String deliveryCode;

    @NotEmpty(message = "The Delivery comment can't be empty")
    @NotBlank(message = "The Delivery comment can't be blank")
    @Size(max =100, message = "The delivery comment size can't be above 100")
    @ApiModelProperty(value = "The Delivery comment ", name = "deliveryComment", dataType = "String")
    String deliveryComment;

    @NotNull(message = "The Delivery date can't be null")
    @PastOrPresent(message = "The delivery date can't be in the future")
    @ApiModelProperty(value = "The Delivery date ", name = "deliveryDate", dataType = "Instant")
    Instant deliveryDate;

    @NotNull(message = "The Delivery state can't be null")
    @NotEmpty(message = "The Delivery state can't be empty")
    @NotBlank(message = "The Delivery state can't be blank")
    @Size(max =7, message = "The delivery state size can't be above 10")
    @ApiModelProperty(value = "The Delivery state ", name = "deliveryState", dataType = "String",
            required = true, allowableValues = "InEditing, Edited, Delivery", example = "InEditing")
    String deliveryState;

    @NotNull(message = "The UserBM associate with the delivery can't be null")
    @ApiModelProperty(value = "The UserBM that register the delivery ", name = "deliveryUserbmDto",
            dataType = "UserBMDto")
    UserBMDto deliveryUserbmDto;

    @ApiModelProperty(value = "The id of the delivery ", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The pointofsale id of the Delivery  can't be null")
    @ApiModelProperty(value = "The pointofsale id of the Delivery ", name = "posDeliveryId", dataType = "Long",
        required = true, example = "0")
    Long posDeliveryId;
    public static DeliveryDto fromEntity(Delivery entity){
        if(entity == null) return null;
        return DeliveryDto.builder()
                .deliveryCode(entity.getDeliveryCode())
                .deliveryComment(entity.getDeliveryComment())
                .deliveryDate(entity.getDeliveryDate())
                .deliveryState(entity.getDeliveryState().name())
                .deliveryUserbmDto(UserBMDto.fromEntity(entity.getDeliveryUserbm()))
                .id(entity.getId())
                .posDeliveryId(entity.getPosDeliveryId())

                .build();
    }

    public static Delivery toEntity(DeliveryDto dto){
        if(dto == null) return null;

        Delivery entity = new Delivery();

        entity.setDeliveryCode(dto.getDeliveryCode());
        entity.setDeliveryComment(dto.getDeliveryComment());
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setDeliveryState(
                dto.getDeliveryState().equalsIgnoreCase(DeliveryState.Delivery.name()) ? DeliveryState.Delivery :
                dto.getDeliveryState().equalsIgnoreCase(DeliveryState.Edited.name()) ? DeliveryState.Edited :
                        DeliveryState.InEditing
        );
        entity.setDeliveryUserbm(UserBMDto.toEntity(dto.getDeliveryUserbmDto()));
        entity.setId(dto.getId());
        entity.setPosDeliveryId(dto.getPosDeliveryId());

        return entity;
    }
}
