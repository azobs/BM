package com.c2psi.bm.dtos.client.client;

import com.c2psi.bm.dtos.stock.product.ArticleDto;
import com.c2psi.bm.dtos.stock.provider.PackagingDto;
import com.c2psi.bm.models.ClientAccount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class ClientAccountDto {
    @ApiModelProperty(value = "The id of the clientaccount", name = "id", dataType = "Long")
    Long id;
    @ApiModelProperty(value = "The number of capsule for the associate article", name = "clientNumberofCapsule",
            dataType = "BigDecimal")
    BigDecimal clientNumberofCapsule;
    @ApiModelProperty(value = "The number of damage for the associate article", name = "clientNumberofDamage",
            dataType = "BigDecimal")
    BigDecimal clientNumberofDamage;
    @ApiModelProperty(value = "The number of packaging for the associate packaging", name = "clientNumberofPackaging",
            dataType = "BigDecimal")
    BigDecimal clientNumberofPackaging;

    @NotNull(message = "The client owner of the account can't be null")
    @ApiModelProperty(value = "The client associate with the account", name = "articleDto",
            dataType = "ClientDto", required = true)
    ClientDto clientDto;
    @NotNull(message = "The client owner of the account can't be null")
    @ApiModelProperty(value = "The article associate with the account", name = "articleDto",
            dataType = "ArticleDto", required = true)
    ArticleDto articleDto;
    @NotNull(message = "The client owner of the account can't be null")
    @ApiModelProperty(value = "The packaging associate with the account", name = "packagingDto",
            dataType = "PackagingDto", required = true)
    PackagingDto packagingDto;

    public static ClientAccountDto fromEntity(ClientAccount clientAccount){
        if(clientAccount == null) return null;
        return ClientAccountDto.builder()
                .articleDto(ArticleDto.fromEntity(clientAccount.getCcArticle()))
                .clientDto(ClientDto.fromEntity(clientAccount.getCcClient()))
                .id(clientAccount.getId())
                .clientNumberofCapsule(clientAccount.getClientNumberofCapsule())
                .clientNumberofDamage(clientAccount.getClientNumberofDamage())
                .clientNumberofPackaging(clientAccount.getClientNumberofPackaging())
                .packagingDto(PackagingDto.fromEntity(clientAccount.getCcPackaging()))

                .build();
    }

    public static ClientAccount toEntity(ClientAccountDto dto){
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setCcArticle(ArticleDto.toEntity(dto.getArticleDto()));
        clientAccount.setCcClient(ClientDto.toEntity(dto.getClientDto()));
        clientAccount.setId(dto.getId());
        clientAccount.setClientNumberofCapsule(dto.getClientNumberofCapsule());
        clientAccount.setClientNumberofDamage(dto.getClientNumberofDamage());
        clientAccount.setClientNumberofPackaging(dto.getClientNumberofPackaging());

        return clientAccount;
    }
}
