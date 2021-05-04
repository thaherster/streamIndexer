package com.sankhya.poc.dbindexer.repositories;

import com.sankhya.poc.dbindexer.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketDao extends CrudRepository<Ticket, UUID> {
}
