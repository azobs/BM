package com.c2psi.bm.repositories.client.command;

import com.c2psi.bm.models.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long> {
}
