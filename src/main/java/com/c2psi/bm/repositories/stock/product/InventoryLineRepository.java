package com.c2psi.bm.repositories.stock.product;

import com.c2psi.bm.models.InventoryLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryLineRepository extends JpaRepository<InventoryLine, Long> {
}
