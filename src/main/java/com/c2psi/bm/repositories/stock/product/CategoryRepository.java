package com.c2psi.bm.repositories.stock.product;

import com.c2psi.bm.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
