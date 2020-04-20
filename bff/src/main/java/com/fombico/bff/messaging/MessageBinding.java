package com.fombico.bff.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageBinding {
    String CHANNEL = "sharedChannel";

    @Output(CHANNEL)
    MessageChannel outputChannel();
}
