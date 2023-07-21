package com.c2psi.bm.dtos.client.command;


import com.c2psi.bm.enumerations.PaymentMethod;
import com.c2psi.bm.models.SaleInvoice;
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
public class SaleInvoiceDto {
    @ApiModelProperty(value = "The SaleInvoice id ", name = "id", dataType = "Long")
    Long id;

    @NotNull(message = "The Pointofsale id of the SaleInvoice can't be null")
    @ApiModelProperty(value = "The Pointofsale if of the SaleInvoice", name = "posSiId", dataType = "Long",
            required = true, example = "0")
    Long posSiId;

    @NotNull(message = "The amount paid of the the number give can't be null")
    @Positive(message = "The amount paid of the the number give must be positive value")
    @ApiModelProperty(value = "The amount paid or the number give effectively", name = "siAmountOrNumberPaid",
            dataType = "BigDecimal", required = true, example = "1")
    BigDecimal siAmountOrNumberPaid;

    @NotNull(message = "The amount to paid of the the number to give can't be null")
    @Positive(message = "The amount to paid of the the number to give must be positive value")
    @ApiModelProperty(value = "The amount expected or the expected number to give", name = "siAmountOrNumberToDelivery",
            dataType = "BigDecimal", required = true, example = "1")
    BigDecimal siAmountOrNumberToDelivery;

    @ApiModelProperty(value = "A comment for the saleInvoice", name = "siComment", dataType = "String")
    String siComment;

    @NotNull(message = "The saleinvoice code can't be null")
    @NotEmpty(message = "The saleinvoice code can't be empty value")
    @NotBlank(message = "The saleinvoice code can't be blank value")
    @Size(max = 10, message = "The saleinvoice code can't be above 10 characters ")
    @ApiModelProperty(value = "A SaleInvoice code", name = "siCode", dataType = "String", required = true,
            example = "SAI_0000")
    String siCode;

    @ApiModelProperty(value = "The delivery date", name = "siDeliverydate", dataType = "Instant")
    Instant siDeliverydate;

    @NotNull(message = "The invoicing date can't be null")
    @ApiModelProperty(value = "The invoicing date", name = "siInvoicingdate", dataType = "Instant")
    Instant siInvoicingdate;

    @NotNull(message = "The payment method can't be null")
    @NotEmpty(message = "The payment method can't be empty value")
    @NotBlank(message = "The payment method can't be blank value")
    @Size(max = 5, message = "The payment method can't be above 05 characters ")
    @ApiModelProperty(value = "The payment method used", name = "siInvoicingdate", dataType = "String", required = true,
            allowableValues = "MOMO, OM, Cash", example = "Cash")
    String siPaymentmethod;

    @NotNull(message = "The total number of colis can't be null")
    @Positive(message = "The total number of colis must be positive value")
    @ApiModelProperty(value = "The total colis in the SaleInvoice", name = "siTotalcolis", dataType = "BigDecimal",
            required = true, example = "1")
    BigDecimal siTotalcolis;

    public static SaleInvoiceDto fromEntity(SaleInvoice entity){
        if(entity == null) return null;
        return SaleInvoiceDto.builder()
                .id(entity.getId())
                .posSiId(entity.getPosSiId())
                .siAmountOrNumberPaid(entity.getSiAmountOrNumberPaid())
                .siAmountOrNumberToDelivery(entity.getSiAmountOrNumberToDelivery())
                .siComment(entity.getSiComment())
                .siCode(entity.getSiCode())
                .siDeliverydate(entity.getSiDeliverydate())
                .siInvoicingdate(entity.getSiInvoicingdate())
                .siPaymentmethod(entity.getSiPaymentmethod().name())
                .siTotalcolis(entity.getSiTotalcolis())
                .build();
    }

    public static SaleInvoice toEntity(SaleInvoiceDto dto){
        if(dto == null) return null;

        SaleInvoice entity = new SaleInvoice();

        entity.setId(dto.getId());
        entity.setPosSiId(dto.getPosSiId());
        entity.setSiAmountOrNumberPaid(dto.getSiAmountOrNumberPaid());
        entity.setSiAmountOrNumberToDelivery(dto.getSiAmountOrNumberToDelivery());
        entity.setSiComment(dto.getSiComment());
        entity.setSiCode(dto.getSiCode());
        entity.setSiDeliverydate(dto.getSiDeliverydate());
        entity.setSiInvoicingdate(dto.getSiInvoicingdate());
        entity.setSiPaymentmethod(
                dto.getSiPaymentmethod().equalsIgnoreCase(PaymentMethod.Cash.name()) ? PaymentMethod.Cash :
                dto.getSiPaymentmethod().equalsIgnoreCase(PaymentMethod.Momo.name()) ? PaymentMethod.Momo :
                        PaymentMethod.Om
        );
        entity.setSiTotalcolis(dto.getSiTotalcolis());

        return entity;
    }
}
