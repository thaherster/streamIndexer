package com.sankhya.poc.dbindexer.stream;

import com.sankhya.poc.dbindexer.config.StreamConstants;
import com.sankhya.poc.dbindexer.entity.Indexable;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static com.sankhya.poc.dbindexer.config.StreamConstants.header_action;
import static com.sankhya.poc.dbindexer.config.StreamConstants.header_classname;

@Service
public class EventStreamService {

    @Autowired
    private EventStream eventStream;







    public void sendData(Indexable data, String action , String className ) {

        eventStream
                .outboundData()
                .send(MessageBuilder
                        .withPayload(data)
                        .setHeader(header_action,action)
                        .setHeader(header_classname,className)
                        .build()
        );

    }
}
