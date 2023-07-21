package com.c2psi.bm.controllers.apiImpl.stock.product;

import com.c2psi.bm.controllers.api.stock.product.TestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiImpl implements TestApi {
    @Override
    public ResponseEntity findAllArticleofPos(Long posId) {
        return null;
    }
}
