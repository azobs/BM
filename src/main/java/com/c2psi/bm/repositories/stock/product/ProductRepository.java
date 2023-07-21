package com.c2psi.bm.repositories.stock.product;

import com.c2psi.bm.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
