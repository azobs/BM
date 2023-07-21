package com.c2psi.bm.dtos;

import com.c2psi.bm.models.Address;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@ApiModel
public class AddressDto {
    @NotNull(message = "The phone number 1 cannot be null")
    @NotEmpty(message = "The phone number 1 cannot be empty value")
    @NotBlank(message = "The phone number 1 cannot be blank value")
    @Size(max = 13, message = "A phone size can't be above 13 characters ")
    @ApiModelProperty(value = "numtel number1", name = "numtel1", dataType = "String",
            example = "678470262", required = true)
    String numtel1;
    @NotEmpty(message = "The phone number 2 cannot be empty value")
    @NotBlank(message = "The phone number 2 cannot be blank value")
    @Size(max = 13, message = "A phone size can't be above 13 characters ")
    @ApiModelProperty(value = "numtel number2", name = "numtel2", dataType = "String", example = "")
    String numtel2;
    @NotEmpty(message = "The phone number 3 cannot be empty value")
    @NotBlank(message = "The phone number 3 cannot be blank value")
    @Size(max = 13, message = "A phone size can't be above 13 characters ")
    @ApiModelProperty(value = "numtel number3", name = "numtel3", dataType = "String", example = "")
    String numtel3;
    @NotEmpty(message = "The living quater name cannot be empty value")
    @NotBlank(message = "The living quater name cannot be blank value")
    @Size(max = 20, message = "A living quater name size can't be above 20 characters ")
    @ApiModelProperty(value = "Name of the quater", name = "quartier", dataType = "String", example = "")
    String quartier;
    @NotEmpty(message = "The living country name cannot be empty value")
    @NotBlank(message = "The living country name cannot be blank value")
    @Size(max = 20, message = "A living country name size can't be above 20 characters ")
    @ApiModelProperty(value = "Name of the country", name = "country", dataType = "String", example = "")
    String pays;
    @NotEmpty(message = "The living town name cannot be empty value")
    @NotBlank(message = "The living town name cannot be blank value")
    @Size(max = 20, message = "A living town name size can't be above 20 characters ")
    @ApiModelProperty(value = "Name of the town", name = "town", dataType = "String", example = "")
    String ville;
    @NotEmpty(message = "The localisation plan name cannot be empty value")
    @NotBlank(message = "The localisation plan name cannot be blank value")
    @Size(max = 20, message = "A localisation plan name can't be above 20 characters ")
    @ApiModelProperty(value = "localisation plan name", name = "localisation", dataType = "String", example = "")
    String localisation;
    @NotNull(message = "The email cannot be null")
    @NotEmpty(message = "The email cannot be empty value")
    @NotBlank(message = "The email cannot be blank value")
    @ApiModelProperty(value = "email", name = "email", dataType = "String", example = "email_@gmail.com", required = true)
    String email;

    public static AddressDto fromEntity(Address address){
        if(address == null) return null;
        return AddressDto.builder()
                .email(address.getEmail())
                .localisation(address.getLocalisation())
                .numtel1(address.getNumtel1())
                .numtel2(address.getNumtel2())
                .numtel3(address.getNumtel3())
                .pays(address.getPays())
                .quartier(address.getQuartier())
                .ville(address.getVille())
                .build();
    }

    public static Address toEntity(AddressDto addressDto){
        if(addressDto == null) return null;
        Address address = new Address();

        address.setEmail(addressDto.getEmail());
        address.setLocalisation(addressDto.getLocalisation());
        address.setNumtel1(addressDto.getNumtel1());
        address.setNumtel2(addressDto.getNumtel2());
        address.setNumtel3(addressDto.getNumtel3());
        address.setPays(addressDto.getPays());
        address.setQuartier(addressDto.getQuartier());
        address.setVille(addressDto.getVille());

        return address;
    }
}
