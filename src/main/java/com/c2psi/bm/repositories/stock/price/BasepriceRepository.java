package com.c2psi.bm.repositories.stock.price;

import com.c2psi.bm.models.Baseprice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasepriceRepository extends JpaRepository<Baseprice, Long> {
}
