package com.fombico.central.messaging;

import com.fombico.central.Book;
import com.fombico.central.persistence.BookEntity;
import com.fombico.central.persistence.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@EnableBinding({MessageBinding.class})
public class MessagingService {

    private BookRepository bookRepository;

    @StreamListener(MessageBinding.CHANNEL)
    public void handleMessage(Message<Book> bookMessage) {
        Book book = bookMessage.getPayload();
        log.info("Received book: {}", book);

        bookRepository.save(BookEntity.builder()
                .author(book.getAuthor())
                .title(book.getTitle())
                .build());
    }
}
