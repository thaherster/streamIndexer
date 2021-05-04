package com.sankhya.poc.dbindexer.controllers;


import com.sankhya.poc.dbindexer.services.GraphQLTicketService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/graphticket")
public class GraphQLTicketController {


    @Autowired
    private GraphQLTicketService ticketService;


    @GetMapping("/health")
    public String getHealth () {

        return "Status : UP";
    }



    @PostMapping
    public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
        ExecutionResult execute = ticketService.getGraphQL().execute(query);

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
