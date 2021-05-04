package com.sankhya.poc.dbindexer.stream;

import com.sankhya.poc.dbindexer.config.StreamConstants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EventStream  {


    @Output(StreamConstants.channel)
    MessageChannel outboundData();


    @Input(StreamConstants.channel)
    SubscribableChannel inboundData();

}