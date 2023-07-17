package com.c2psi.bm.controllers.api;

import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;

@Validated
@Api("/bm/v1"+"/article")
public interface ArticleApi {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/bm/v1"+"/article/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "findAllArticleofPos", notes = "Search all articles in a pointofsale",
            responseContainer = "List<ArticleDto>")
    @ApiResponses(value={
            @ApiResponse(code=200, message="The list of article of pointofsale found successfully"),
            @ApiResponse(code=404, message="Error faced during the finding process")
    })
    ResponseEntity findAllArticleofPos(
            @ApiParam(name = "posId", type = "Long", required = true,
                    value="Id of the concerned pointofsale", example = "1")
            @NotNull @PathVariable("posId") Long posId);

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
