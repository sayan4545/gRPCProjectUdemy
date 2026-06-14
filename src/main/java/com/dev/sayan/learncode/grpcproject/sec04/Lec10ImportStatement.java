package com.dev.sayan.learncode.grpcproject.sec04;

import com.sayan.models.common.Address;
import com.sayan.models.common.BodyStyle;
import com.sayan.models.common.Car;
import com.sayan.models.sec04.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec10ImportStatement {

    private static final Logger log = LoggerFactory.getLogger(Lec10ImportStatement.class);

    public static void main(String[] args) {
        var person01 = Person.newBuilder()
                .setName("Chandrika Dey")
                .setAge(27)
                .setAddress(Address.newBuilder().setState("West bengal")
                        .setCity("Chittaranjan")
                        .setStreet("22")
                        .build())
                .setCar(Car.newBuilder()
                        .setBodyStyle(BodyStyle.SUV)
                        .setMake("Mahindra")
                        .setModel("Thar").build())
                .build();

        var person02 = Person.newBuilder()
                        .setAddress(Address.newBuilder().setState("karnataka")
                                .setStreet("2nd main")
                                .setCity("Bengaluru")
                                .build())
                                .setAge(32)
                                        .setName("Sayan Chatterjee")
                                                .setCar(Car.newBuilder()
                                                        .setBodyStyle(BodyStyle.SEDAN)
                                                        .setMake("Tata")
                                                        .setModel("Tiago")
                                                        .build())
                                                        .build();



        log.info("person : {}",person01);
        log.info("{}",person01.hasAddress());
        log.info("{}",person01.hasCar());


        log.info("person02 : {}",person02);
        log.info("{}",person02.hasAddress());
        log.info("{}",person02.hasCar());




    }

}
