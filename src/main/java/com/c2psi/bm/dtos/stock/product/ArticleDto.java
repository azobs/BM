package com.c2psi.bm.dtos.stock.product;

import com.c2psi.bm.models.Article;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@ApiModel
public class ArticleDto {
    @ApiModelProperty(value = "The id of the article", name = "id", dataType = "Long")
    Long id;
    @NotNull(message = "The article code cannot be null")
    @NotEmpty(message = "The article code cannot be empty")
    @NotBlank(message = "The article code cannot be blank")
    @Size(min = 3, max = 30, message = "The article code size must be between 3 and 30 characters")
    @ApiModelProperty(value = "The code of the article", name = "artCode", dataType = "String", example = "Code")
    String artCode;
    @NotNull(message = "The article name cannot be null")
    @NotEmpty(message = "The article name cannot be empty")
    @NotBlank(message = "The article name cannot be blank")
    @Size(min = 3, max = 75, message = "The article name size must be between 3 and 75 characters")
    @ApiModelProperty(value = "The name of the article", name = "artName", dataType = "String", example = "Name")
    String artName;
    @NotNull(message = "The article shortname cannot be null")
    @NotEmpty(message = "The article shortname cannot be empty")
    @NotBlank(message = "The article shortname cannot be blank")
    @Size(max = 25, message = "The article shortname size must be between 3 and 50 characters")
    @ApiModelProperty(value = "The shortname of the article", name = "artShortname", dataType = "String", example = "Shortname")
    String artShortname;
    @Size(max = 150, message = "The article shortname size must be at least 150 characters")
    @ApiModelProperty(value = "The description of the article", name = "artDescription", dataType = "String", example = "details about the article")
    String artDescription;
    @NotNull(message = "The threshold value cannot be null")
    @PositiveOrZero(message = "The threshold value must be positive or zero")
    @ApiModelProperty(value = "The threshold of the article", name = "artThreshold", dataType = "BigDecimal", example = "5")
    BigDecimal artThreshold;
    /*****
     * A negative value means there the article cannot be selling in whole
     */
    @NotNull(message = "The low limit value to sell in whole value cannot be null")
    @ApiModelProperty(value = "The low limit to sell in whole", name = "artLowLimitWholesale", dataType = "BigDecimal",
            example = "100")
    BigDecimal artLowLimitWholesale;
    /*****
     * A negative value means there the article cannot be selling in semi whole
     * If an article cannot be selling in semi whole then it cannot be also selling in whole.
     */
    @NotNull(message = "The low limit value to sell in semi whole value cannot be null")
    @ApiModelProperty(value = "The low limit to sell in semi whole", name = "artLowLimitSemiWholesale", dataType = "BigDecimal",
            example = "75")
    BigDecimal artLowLimitSemiWholesale;
    @NotNull(message = "The current quantity in stock cannot be null")
    @PositiveOrZero(message = "The current quantity in stock must be positive or zero")
    @ApiModelProperty(value = "The real quantity in stock", name = "artQuantityinstock", dataType = "BigDecimal",
            example = "10")
    BigDecimal artQuantityinstock;
    @NotNull(message = "The id of the pointofsale owner cannot be null")
    Long artPosId;

    public static ArticleDto fromEntity(Article article){
        if(article == null){
            return null;
        }
        return ArticleDto.builder()
                .artCode(article.getArtCode())
                .artDescription(article.getArtDescription())
                .id(article.getId())
                .artLowLimitSemiWholesale(article.getArtLowLimitSemiWholesale())
                .artLowLimitWholesale(article.getArtLowLimitWholesale())
                .artName(article.getArtName())
                .artPosId(article.getArtPosId())
                .artQuantityinstock(article.getArtQuantityinstock())
                .artShortname(article.getArtShortname())
                .artThreshold(article.getArtThreshold())

                .build();
    }
    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article art = new Article();
        art.setArtCode(articleDto.getArtCode());
        art.setArtDescription(articleDto.getArtDescription());
        art.setId(articleDto.getId());
        art.setArtLowLimitSemiWholesale(articleDto.getArtLowLimitSemiWholesale());
        art.setArtLowLimitWholesale(articleDto.getArtLowLimitWholesale());
        art.setArtName(articleDto.getArtName());
        art.setArtPosId(articleDto.getArtPosId());
        art.setArtQuantityinstock(articleDto.getArtQuantityinstock());
        art.setArtShortname(articleDto.getArtShortname());
        art.setArtThreshold(articleDto.getArtThreshold());

        return art;
    }
}
