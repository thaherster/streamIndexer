package com.sankhya.poc.dbindexer.controllers;


import com.sankhya.poc.dbindexer.entity.Ticket;
import com.sankhya.poc.dbindexer.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {


    @Autowired
    private TicketService ticketService;


    @GetMapping("/health")
    public String getHealth () {

        return "Status : UP";
    }

    @PostMapping("/booktickets")
    public Ticket bookTicket (@RequestBody  Ticket ticket) {

       return ticketService.saveTicket(ticket);

    }

    @GetMapping("/gettickets")
    public List<Ticket> getAllTickets () {

        return ticketService.getAllTickets();
    }
}
