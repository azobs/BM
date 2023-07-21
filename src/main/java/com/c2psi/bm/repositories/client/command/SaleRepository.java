package com.c2psi.bm.repositories.client.command;

import com.c2psi.bm.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
