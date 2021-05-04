package com.sankhya.poc.dbindexer.services.datafetcher;


import com.sankhya.poc.dbindexer.entity.TicketIndex;
import com.sankhya.poc.dbindexer.repositories.TicketIndexDao;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TicketDataFetcher implements DataFetcher<TicketIndex> {

    @Autowired
    private TicketIndexDao repository;

    @Override
    public TicketIndex get(DataFetchingEnvironment environment) {
      String id =  environment.getArgument("id");
        return repository.findById(id).get();
    }
}
