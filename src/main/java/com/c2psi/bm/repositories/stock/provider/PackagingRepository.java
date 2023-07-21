package com.c2psi.bm.repositories.stock.provider;

import com.c2psi.bm.models.Packaging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackagingRepository extends JpaRepository<Packaging, Long> {
}
