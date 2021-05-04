package com.sankhya.poc.dbindexer.services;


import com.sankhya.poc.dbindexer.entity.Ticket;
import com.sankhya.poc.dbindexer.repositories.TicketDao;
import com.sankhya.poc.dbindexer.stream.EventStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private EventStreamService eventStreamService;

    public Ticket saveTicket(Ticket ticket) {

        ticket.setId(UUID.randomUUID());
        ticketDao.save(ticket);
        //Parallel task
        eventStreamService.sendData(ticket,"SAVE",ticket.getClass().getName());
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        return (List<Ticket>) ticketDao.findAll();
    }

}
