package com.sankhya.poc.dbindexer.services.datafetcher;


import com.sankhya.poc.dbindexer.entity.TicketIndex;
import com.sankhya.poc.dbindexer.repositories.TicketIndexDao;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllTicketsDataFetcher implements DataFetcher<List<TicketIndex>> {

    @Autowired
    private TicketIndexDao repository;

    @Override
    public List<TicketIndex> get(DataFetchingEnvironment environment) {
        return repository.findAll();
    }
}
