package com.c2psi.bm.repositories.stock.price;

import com.c2psi.bm.models.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {
}
