package com.fombico.bff;

import com.fombico.bff.messaging.MessageBinding;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class BookController {

    private MessageBinding messageBinding;

    @PostMapping("/book")
    public void insert(@RequestBody Book book) {
        log.info("Sending book: {}", book);
        messageBinding.outputChannel().send(MessageBuilder.withPayload(book).build());
    }
}
