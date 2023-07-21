package com.c2psi.bm.repositories.stock.product;

import com.c2psi.bm.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
