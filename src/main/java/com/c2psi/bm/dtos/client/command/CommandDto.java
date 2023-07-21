package com.c2psi.bm.dtos.client.command;

import com.c2psi.bm.dtos.client.client.ClientDto;
import com.c2psi.bm.dtos.client.delivery.DeliveryDto;
import com.c2psi.bm.dtos.pos.loading.LoadingDto;
import com.c2psi.bm.dtos.pos.userbm.UserBMDto;
import com.c2psi.bm.enumerations.CommandNature;
import com.c2psi.bm.enumerations.CommandState;
import com.c2psi.bm.models.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
@Data
@Builder
@ApiModel
public class CommandDto {
    @NotNull(message = "The Client associate with the Command can't be null")
    @ApiModelProperty(value = "The Client associate with the Command", name = "cmdClientDto",
            dataType = "ClientDto", required = true)
    ClientDto cmdClientDto;
    @NotEmpty(message = "The comment associate to the Command can't be empty value")
    @NotBlank(message = "The comment associate to the Command can't be blank value")
    @Size(max = 100, message = "The comment associate to the Command can't be above 100 characters ")
    @ApiModelProperty(value = "A Comment for the Command", name = "cmdComment", dataType = "String")
    String cmdComment;
    @NotNull(message = "The Command date can't be null")
    @ApiModelProperty(value = "Date of the Command", name = "cmdDate", dataType = "Instant", required = true)
    Instant cmdDate;
    @ApiModelProperty(value = "The Delivery in which the Command is placed", name = "cmdDeliveryDto",
            dataType = "DeliveryDto")
    DeliveryDto cmdDeliveryDto;
    @ApiModelProperty(value = "The Loading in which the Command can belong", name = "cmdLoadingDto",
            dataType = "LoadingDto")
    LoadingDto cmdLoadingDto;
    @NotNull(message = "The Command nature can't be null")
    @NotEmpty(message = "The Command nature can't be empty value")
    @NotBlank(message = "The Command nature can't be blank value")
    @Size(max = 10, message = "The Command nature size can't be above 10 characters ")
    @ApiModelProperty(value = "The nature of the Command", name = "cmdNature",
            dataType = "String", required = true, allowableValues = "Capsule, Cash, Damage", example = "Capsule")
    String cmdNature;
    @NotNull(message = "The Command state can't be null")
    @NotEmpty(message = "The Command state can't be empty value")
    @NotBlank(message = "The Command state can't be blank value")
    @Size(max = 10, message = "The Command state size can't be above 10 characters ")
    @ApiModelProperty(value = "The State of the Command", name = "cmdState",
            dataType = "String", required = true, allowableValues = "InEditing, Edited, InDelivery, Delivery",
            example = "InEditing")
    String cmdState;
    /*******************
     * La facture associe a la command doit etre unique. et aucune autre command ne peut etre associe a cette facture
     */
    @ApiModelProperty(value = "The SaleInvoice of the command", name = "cmdSaleinvoiceDto",
            dataType = "SaleInvoiceDto")
    SaleInvoiceDto cmdSaleinvoiceDto;
    @NotNull(message = "The UserBM that register the Command can't be null")
    @ApiModelProperty(value = "The UserBM that register the Command", name = "cmdUserbmDto",
            dataType = "UserBMDto", required = true)
    UserBMDto cmdUserbmDto;
    @ApiModelProperty(value = "The id of the command", name = "id", dataType = "Long")
    Long id;
    @NotNull(message = "The pointofsale id of the Command can't be null")
    @ApiModelProperty(value = "The pointofsale id of the command", name = "posCmdId", dataType = "Long", required = true)
    Long posCmdId;


    public static CommandDto fromEntity(Command entity){
        if(entity == null) return null;
        return CommandDto.builder()
                .cmdClientDto(ClientDto.fromEntity(entity.getCmdClient()))
                .cmdComment(entity.getCmdComment())
                .cmdDate(entity.getCmdDate())
                .cmdDeliveryDto(DeliveryDto.fromEntity(entity.getCmdDelivery()))
                .cmdLoadingDto(LoadingDto.fromEntity(entity.getCmdLoading()))
                .cmdNature(entity.getCmdNature().name())
                .cmdState(entity.getCmdState().name())
                .cmdSaleinvoiceDto(SaleInvoiceDto.fromEntity(entity.getCmdSaleinvoice()))
                .cmdUserbmDto(UserBMDto.fromEntity(entity.getCmdUserbm()))
                .id(entity.getId())
                .posCmdId(entity.getPosCmdId())

                .build();
    }

    public static Command  toEntity(CommandDto dto){
        if(dto == null) return null;
        Command entity = new Command();

        entity.setCmdClient(ClientDto.toEntity(dto.getCmdClientDto()));
        entity.setCmdComment(dto.getCmdComment());
        entity.setCmdDate(dto.getCmdDate());
        entity.setCmdDelivery(DeliveryDto.toEntity(dto.getCmdDeliveryDto()));
        entity.setCmdLoading(LoadingDto.toEntity(dto.getCmdLoadingDto()));
        entity.setCmdNature(
                dto.getCmdNature().equalsIgnoreCase(CommandNature.Capsule.name()) ? CommandNature.Capsule :
                dto.getCmdNature().equalsIgnoreCase(CommandNature.Cash.name()) ? CommandNature.Cash : CommandNature.Damage

        );
        entity.setCmdState(
                dto.getCmdState().equalsIgnoreCase(CommandState.Delivery.name()) ? CommandState.Delivery :
                dto.getCmdState().equalsIgnoreCase(CommandState.Edited.name()) ? CommandState.Edited :
                dto.getCmdState().equalsIgnoreCase(CommandState.InDelivery.name()) ? CommandState.InDelivery :
                        CommandState.InEditing
        );
        entity.setCmdSaleinvoice(SaleInvoiceDto.toEntity(dto.getCmdSaleinvoiceDto()));
        entity.setCmdUserbm(UserBMDto.toEntity(dto.getCmdUserbmDto()));
        entity.setId(dto.getId());
        entity.setPosCmdId(dto.getPosCmdId());

        return entity;
    }
}
