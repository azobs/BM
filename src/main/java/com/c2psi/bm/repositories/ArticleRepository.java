package com.c2psi.bm.repositories;

import com.c2psi.bm.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findArticleById(Long artId);
    @Query("SELECT art FROM Article art WHERE art.artCode=:artCode AND art.artPosId=:posId")
    Optional<Article> findArticleByArtCodeAndPos(@Param("artCode") String artCode, @Param("posId") Long posId);

}
