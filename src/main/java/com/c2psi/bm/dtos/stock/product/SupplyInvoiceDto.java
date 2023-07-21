package com.c2psi.bm.dtos.stock.product;


import com.c2psi.bm.enumerations.PaymentMethod;
import com.c2psi.bm.models.SupplyInvoice;
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
public class SupplyInvoiceDto {

    @ApiModelProperty(value = "The SupplyInvoice id", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The Pointofsale id of the SupplyInvoice can't be null")
    @ApiModelProperty(value = "The Pointofsale id of the SupplyInvoice", name = "posSiId", dataType = "Long",
            required = true, example = "0")
    Long posSiId;

    @NotNull(message = "The amount to pay or the number of article to delivery can't be null")
    @Positive(message = "The amount to paid or the number of article to deliver must be positive")
    @ApiModelProperty(value = "The amount to pay or the number of article to delivery", name = "siAmountOrNumberExpected",
            dataType = "BigDecimal", required = true, example = "0")
    BigDecimal siAmountOrNumberExpected;

    @NotNull(message = "The amount effectively paid or the number of article effectively deliver can't be null")
    @Positive(message = "The amount effectively paid or the number of article effectively deliver must be positive")
    @ApiModelProperty(value = "The amount effectively paid or the number of article effectively deliver",
            name = "siAmountOrNumberPaid", dataType = "BigDecimal", required = true, example = "0")
    BigDecimal siAmountOrNumberPaid;

    @NotNull(message = "The supplyinvoice code can't be null")
    @NotEmpty(message = "The supplyinvoice code can't be empty")
    @NotBlank(message = "The supplyinvoice code can't be blank")
    @Size(max = 10, message = "The supplyinvoice code size can't be above 10")
    @ApiModelProperty(value = "The supplyinvoice code ", name = "siCode", dataType = "String", required = true,
            example = "SUI_0000")
    String siCode;

    @NotEmpty(message = "The supplyinvoice comment can't be empty")
    @NotBlank(message = "The supplyinvoice comment can't be blank")
    @Size(max = 100, message = "The supplyinvoice comment size can't be above 100")
    @ApiModelProperty(value = "The supplyinvoice comment ", name = "siComment", dataType = "String")
    String siComment;

    @NotNull(message = "The supplyinvoice delivery date can't be null")
    @PastOrPresent(message = "The supplyinvoice delivery date can't be in the future")
    @ApiModelProperty(value = "The supplyinvoice delivery date ", name = "siDeliverydate", dataType = "Instant")
    Instant siDeliverydate;

    @NotNull(message = "The supplyinvoice invoicing date can't be null")
    @PastOrPresent(message = "The supplyinvoice invoicing date can't be in the future")
    @ApiModelProperty(value = "The supplyinvoice invoicing date ", name = "siInvoicingdate", dataType = "Instant")
    Instant siInvoicingdate;

    @NotNull(message = "The payment method can't be null")
    @NotEmpty(message = "The payment method can't be empty")
    @NotBlank(message = "The payment method can't be blank")
    @Size(max = 10, message = "The payment method size can't be above 10")
    @ApiModelProperty(value = "The payment method used ", name = "siPaymentmethod", dataType = "String",
            required = true, allowableValues = "Cash, Momo, Om", example = "Cash")
    String siPaymentmethod;

    @NotEmpty(message = "The picture that illustrate the supply invoice can't be empty")
    @NotBlank(message = "The picture that illustrate the supply invoice can't be blank")
    @Size(max = 10, message = "The picture that illustrate the supply invoice size can't be above 10")
    @ApiModelProperty(value = "The picture that illustrate the supply invoice", name = "siPicture",
            dataType = "String")
    String siPicture;

    @NotNull(message = "The total number of colis can't be null")
    @Positive(message = "The total number of colis must be positive")
    @ApiModelProperty(value = "The total number of colis in the supply invoice", name = "siTotalcolis",
            dataType = "BigDecimal", required = true, example = "1")
    BigDecimal siTotalcolis;


    public static SupplyInvoiceDto fromEntity(SupplyInvoice entity){

        if(entity == null) return null;
        return SupplyInvoiceDto.builder()
                .id(entity.getId())
                .posSiId(entity.getPosSiId())
                .siAmountOrNumberExpected(entity.getSiAmountOrNumberExpected())
                .siAmountOrNumberPaid(entity.getSiAmountOrNumberPaid())
                .siCode(entity.getSiCode())
                .siComment(entity.getSiComment())
                .siDeliverydate(entity.getSiDeliverydate())
                .siInvoicingdate(entity.getSiInvoicingdate())
                .siPaymentmethod(entity.getSiPaymentmethod().name())
                .siPicture(entity.getSiPicture())
                .siTotalcolis(entity.getSiTotalcolis())

                .build();
    }

    public static SupplyInvoice  toEntity(SupplyInvoiceDto dto){

        if(dto == null) return null;
        SupplyInvoice entity = new SupplyInvoice();
        entity.setId(dto.getId());
        entity.setPosSiId(dto.getPosSiId());
        entity.setSiAmountOrNumberExpected(dto.getSiAmountOrNumberExpected());
        entity.setSiAmountOrNumberPaid(dto.getSiAmountOrNumberPaid());
        entity.setSiCode(dto.getSiCode());
        entity.setSiComment(dto.getSiComment());
        entity.setSiDeliverydate(dto.getSiDeliverydate());
        entity.setSiInvoicingdate(dto.getSiInvoicingdate());
        entity.setSiPaymentmethod(
                dto.getSiPaymentmethod().equalsIgnoreCase(PaymentMethod.Cash.name()) ? PaymentMethod.Cash :
                dto.getSiPaymentmethod().equalsIgnoreCase(PaymentMethod.Momo.name()) ? PaymentMethod.Momo :
                        PaymentMethod.Om
        );
        entity.setSiPicture(dto.getSiPicture());
        entity.setSiTotalcolis(dto.getSiTotalcolis());

        return entity;
    }
}
