package com.c2psi.bm.dtos;

import com.c2psi.bm.enumerations.OperationType;
import com.c2psi.bm.models.Operation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.Instant;

@Data
@Builder
@ApiModel
public class OperationDto {
    @NotNull(message = "The operation date cannot be null")
    @PastOrPresent(message = "The operation date can't be in the future")
    @ApiModelProperty(value = "operation date", name = "opDate", dataType = "Instant", required = true)
    Instant opDate;
    @NotNull(message = "The operation object cannot be null")
    @NotEmpty(message = "The operation object cannot be empty value")
    @NotBlank(message = "The operation object cannot be blank value")
    @Size(max = 25, message = "The operation object be above 25 characters ")
    @ApiModelProperty(value = "operation object", name = "opObject", dataType = "String", example = "objet",
            required = true)
    String opObject;
    @Size(max = 256, message = "The operation description be above 256 characters ")
    @ApiModelProperty(value = "operation description", name = "opDescription", dataType = "String", example = "description")
    String opDescription;
    @NotNull(message = "The operation type cannot be null")
    @ApiModelProperty(value = "operation type", name = "opType", dataType = "String", example = "description",
            allowableValues = "Credit, Withdrawal,  Change, Others")
    String opType;

    public static OperationDto fromEntity(Operation operation){
        if(operation == null) return null;
        return OperationDto.builder()
                .opDate(operation.getOpDate())
                .opDescription(operation.getOpDescription())
                .opObject(operation.getOpObject())
                .opType(operation.getOpType().name())

                .build();
    }

    public static Operation toEntity(OperationDto operationDto){
        if(operationDto == null) return null;
        Operation operation = new Operation();
        operation.setOpDate(operationDto.getOpDate());
        operation.setOpDescription(operationDto.getOpDescription());
        operation.setOpObject(operationDto.getOpObject());
        operation.setOpType(
                operationDto.getOpType().equalsIgnoreCase(OperationType.Change.name()) ? OperationType.Change :
                operationDto.getOpType().equalsIgnoreCase(OperationType.Credit.name()) ? OperationType.Credit :
                operationDto.getOpType().equalsIgnoreCase(OperationType.Withdrawal.name()) ? OperationType.Withdrawal :
                        OperationType.Others
        );
        return operation;
    }
}
