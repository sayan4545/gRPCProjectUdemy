package com.dev.sayan.learncode.grpcproject.sec03;

import com.sayan.models.sec03.Address;
import com.sayan.models.sec03.School;
import com.sayan.models.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositionDemo {
    private static final Logger log = LoggerFactory.getLogger(CompositionDemo.class);

    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setCity("Bengaluru")
                .setState("Karnataka")
                .setStreet("Whitefield")
                .build();

        Student student = Student.newBuilder()
                .setName("Chandrika")
                .setId(1)
                .setAddress(address)
                .build();

        School school = School
                .newBuilder()
                .setId(1)
                .setName("CHS")
                .setAddress(Address.newBuilder()
                        .setState("WEST BENGAL")
                        .setCity("CHITTARANJAN")
                        .setStreet("22"))
                .build();

        log.info("student : {}",student);
        log.info("address : {}",address);
        log.info("school : {}",school);
    }
}
