package com.fombico.central.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageBinding {
    String CHANNEL = "sharedChannel";

    @Input(CHANNEL)
    SubscribableChannel inputChannel();
}
