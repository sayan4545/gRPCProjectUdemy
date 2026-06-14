package com.dev.sayan.learncode.grpcproject.sec03;

import com.sayan.models.sec03.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.deser.jdk.RadixDeserializerFactory;

public class Lec08DefaultValues {

    private static final Logger log = LoggerFactory.getLogger(Lec08DefaultValues.class);
    public static void main(String[] args) {

        var school = School.newBuilder().build();
//        log.info("{}",school.getId());
//        log.info("{}",school.getName());
//        log.info("{}",school.getAddress());

//        log.info("? default value : {}",school.getAddress().equals(Address.getDefaultInstance()));
//
//        log.info("has address ? : {}", school.hasAddress());

        var library = Library.newBuilder().build();
        var dealer02 = Dealer.newBuilder().build();
        var car03 = Car.newBuilder().build();

        log.info("{}",library.getBooksList());
        log.info("{}",dealer02.getInventoryMap());
        log.info("{}",car03.getBodyStyle());



    }
}
