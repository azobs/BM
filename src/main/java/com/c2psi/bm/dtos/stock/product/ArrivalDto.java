package com.c2psi.bm.dtos.stock.product;

import com.c2psi.bm.enumerations.ArrivalNature;
import com.c2psi.bm.enumerations.ArrivalType;
import com.c2psi.bm.models.Arrival;
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
public class ArrivalDto {
    @NotNull(message = "The Article associated with the Arrival can't be null")
    @ApiModelProperty(value = "The Article associated with the Arrival", name = "aArticleDto", dataType = "ArticleDto")
    ArticleDto aArticleDto;

    @NotNull(message = "The Arrival date can't be null")
    @PastOrPresent(message = "The arrival date can't be in the future")
    @ApiModelProperty(value = "The Arrival date ", name = "arrivalDate", dataType = "Instant")
    Instant arrivalDate;

    @NotNull(message = "The Arrival unit price can't be null")
    @Positive(message = "The unit price must be positive")
    @ApiModelProperty(value = "The Arrival unit price ", name = "arrivalUnitprice", dataType = "BigDecimal",
            required = true, example = "1")
    BigDecimal arrivalUnitprice;

    @NotNull(message = "The Arrival nature can't be null")
    @NotEmpty(message = "The Arrival nature can't be empty")
    @NotBlank(message = "The Arrival nature can't be blank")
    @Size(max = 10, message = "The Arrival nature size can't be above 10")
    @ApiModelProperty(value = "The Arrival nature ", name = "arrivalNature", dataType = "String",
            required = true, allowableValues = "Capsule, Cash, Damage", example = "Cash")
    String arrivalNature;

    @NotNull(message = "The Arrival type can't be null")
    @NotEmpty(message = "The Arrival type can't be empty")
    @NotBlank(message = "The Arrival type can't be blank")
    @Size(max = 10, message = "The Arrival type size can't be above 10")
    @ApiModelProperty(value = "The Arrival type ", name = "arrivalType", dataType = "String",
            required = true, allowableValues = "Divers, Standard", example = "Standard")
    String arrivalType;

    @ApiModelProperty(value = "The invoice associate to the Arrival", name = "aSupplyInvoiceDto",
            dataType = "SupplyInvoiceDto")
    SupplyInvoiceDto aSupplyInvoiceDto;

    @NotNull(message = "The delivery quantity in the arrival can't be null")
    @ApiModelProperty(value = "The delivery quantity in the arrival ", name = "deliveryQuantity", dataType = "BigDecimal",
            required = true, example = "1")
    BigDecimal deliveryQuantity;

    @ApiModelProperty(value = "The arrival id ", name = "id", dataType = "Long")
    Long id;

    public static ArrivalDto fromEntity(Arrival entity){
        if(entity == null) return null;
        return ArrivalDto.builder()
                .aArticleDto(ArticleDto.fromEntity(entity.getAArticle()))
                .arrivalDate(entity.getArrivalDate())
                .arrivalUnitprice(entity.getArrivalUnitprice())
                .arrivalNature(entity.getArrivalNature().name())
                .arrivalType(entity.getArrivalType().name())
                .aSupplyInvoiceDto(SupplyInvoiceDto.fromEntity(entity.getASupplyInvoice()))
                .deliveryQuantity(entity.getDeliveryQuantity())
                .id(entity.getId())

                .build();
    }

    public static Arrival  toEntity(ArrivalDto dto){
        if(dto == null) return null;
        Arrival entity = new Arrival();
        entity.setAArticle(ArticleDto.toEntity(dto.getAArticleDto()));
        entity.setArrivalDate(dto.getArrivalDate());
        entity.setArrivalUnitprice(dto.getArrivalUnitprice());
        entity.setArrivalNature(
                dto.getArrivalNature().equalsIgnoreCase(ArrivalNature.Capsule.name()) ? ArrivalNature.Capsule :
                dto.getArrivalNature().equalsIgnoreCase(ArrivalNature.Cash.name()) ? ArrivalNature.Cash :
                        ArrivalNature.Damage
        );
        entity.setArrivalType(
                dto.getArrivalType().equalsIgnoreCase(ArrivalType.Divers.name()) ? ArrivalType.Divers :
                        ArrivalType.Standard
        );
        entity.setASupplyInvoice(SupplyInvoiceDto.toEntity(dto.getASupplyInvoiceDto()));
        entity.setDeliveryQuantity(dto.getDeliveryQuantity());
        entity.setId(dto.getId());
        return entity;
    }
}
