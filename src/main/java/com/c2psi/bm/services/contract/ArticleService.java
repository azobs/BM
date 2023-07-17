package com.c2psi.bm.services.contract;

import com.c2psi.bm.dtos.ArticleDto;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> findAllArticleofPos(Long posId);

}
