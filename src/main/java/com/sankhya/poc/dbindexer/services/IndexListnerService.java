package com.sankhya.poc.dbindexer.services;


import com.sankhya.poc.dbindexer.config.StreamConstants;
import com.sankhya.poc.dbindexer.entity.TicketIndex;
import com.sankhya.poc.dbindexer.repositories.TicketIndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class IndexListnerService  {

    @Autowired
    private TicketIndexDao ticketIndexDao;

    @StreamListener(StreamConstants.channel)
    public void listenTicketEvents(@Payload TicketIndex ticket)
    {

        ticketIndexDao.save(ticket);

    }


}
