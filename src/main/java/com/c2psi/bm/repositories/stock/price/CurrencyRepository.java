package com.c2psi.bm.repositories.stock.price;

import com.c2psi.bm.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
