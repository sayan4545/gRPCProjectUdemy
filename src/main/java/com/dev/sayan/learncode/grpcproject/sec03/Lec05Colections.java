package com.dev.sayan.learncode.grpcproject.sec03;

import com.sayan.models.sec03.Book;
import com.sayan.models.sec03.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Lec05Colections {
    private static final Logger log = LoggerFactory.getLogger(Lec05Colections.class);

    public static void main(String[] args) {

        var book01 = Book.newBuilder()
                .setAuthor("Sayan Chatterjee")
                .setTitle("Java digest")
                .setPublicationYear(2025)
                .build();
        var book02 = Book.newBuilder()
                .setAuthor("Chandrika Dey")
                .setTitle("Mainframe digest")
                .setPublicationYear(2023)
                .build();
        var book03 = Book.newBuilder()
                .setAuthor("Rina Dey")
                .setTitle("Botany digest")
                .setPublicationYear(2025)
                .build();
        var book04 = Book.newBuilder()
                .setAuthor("Sudhanshu Dey")
                .setTitle("Electrical Engineering digest")
                .setPublicationYear(2025)
                .build();

        Library library = Library.newBuilder()
                .setName("fantasy")
                .addAllBooks(List.of(book01,book02,book03,book04))
                .build();


        log.info("library : {}, {}",library.getName(),library);


    }
}
