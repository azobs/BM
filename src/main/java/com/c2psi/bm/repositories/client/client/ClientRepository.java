package com.c2psi.bm.repositories.client.client;

import com.c2psi.bm.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
