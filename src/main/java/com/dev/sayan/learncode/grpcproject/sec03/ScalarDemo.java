package com.dev.sayan.learncode.grpcproject.sec03;

import com.sayan.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScalarDemo {

    private static final Logger log = LoggerFactory.getLogger(ScalarDemo.class);

    public static void main(String[] args) {

        var person01 = Person.newBuilder()
                .setLastName("Sayan")
                .setAge(32)
                .setEmail("sayan@gmail.com")
                .setEmployed(true)
                .setSalary(23000.90)
                .setBankBalance(-1000)
                .setBankAccountNumber(12345678)
                .build();

        log.info("{}",person01);
    }



}
