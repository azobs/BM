package com.c2psi.bm.controllers.apiImpl;

import com.c2psi.bm.controllers.api.ArticleApi;
import com.c2psi.bm.dtos.ArticleDto;
import com.c2psi.bm.services.contract.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArticleApiImpl implements ArticleApi {
    private ArticleService articleService;

    @Autowired
    public ArticleApiImpl(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ResponseEntity findAllArticleofPos(Long posId) {
        List<ArticleDto> l = articleService.findAllArticleofPos(posId);
        Map<String, Object> map = new LinkedHashMap<>();
        map.clear();
        map.put("status", HttpStatus.OK);
        map.put("message", "Nothing");
        map.put("data", l);
        map.put("cause", "Nothing");
        return new ResponseEntity(map, HttpStatus.OK);
    }
}
