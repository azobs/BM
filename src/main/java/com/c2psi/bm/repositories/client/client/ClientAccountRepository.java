package com.c2psi.bm.repositories.client.client;

import com.c2psi.bm.models.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {
}
