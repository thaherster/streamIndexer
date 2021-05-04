package com.sankhya.poc.dbindexer.services;

import com.sankhya.poc.dbindexer.services.datafetcher.AllTicketsDataFetcher;
import com.sankhya.poc.dbindexer.services.datafetcher.TicketDataFetcher;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLTicketService {



    @Value("classpath:ticket.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllTicketsDataFetcher allTicketsDataFetcher;

    @Autowired
    private TicketDataFetcher ticketDataFetcher;



    @PostConstruct
    private void loadSchema() throws IOException{
        //get schema
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allTickets", allTicketsDataFetcher)
                        .dataFetcher("ticket", ticketDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }

}
