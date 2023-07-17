package com.c2psi.bm.services.contractImpl;

import com.c2psi.bm.repositories.ArticleRepository;
import com.c2psi.bm.dtos.ArticleDto;
import com.c2psi.bm.services.contract.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value="ArticleServiceV1")
@Slf4j
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public List<ArticleDto> findAllArticleofPos(Long posId) {
        List<ArticleDto> l = new ArrayList<>();
        l.add(ArticleDto.builder()
                .id(Long.valueOf(12))
                .artName("dsdsd")
                .build());
        return l;
    }
}
