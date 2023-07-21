package com.c2psi.bm.repositories.client.command;

import com.c2psi.bm.models.SaleInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleInvoiceRepository extends JpaRepository<SaleInvoice, Long> {
}
