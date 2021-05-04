package com.sankhya.poc.dbindexer.repositories;

import com.sankhya.poc.dbindexer.entity.TicketIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketIndexDao extends JpaRepository<TicketIndex, String> {
}
