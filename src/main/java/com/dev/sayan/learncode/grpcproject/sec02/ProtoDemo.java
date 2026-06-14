package com.dev.sayan.learncode.grpcproject.sec02;

import com.sayan.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {

    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);
    public static void main(String[] args) {

        var person01 = createPerson("Chandrika",27);
        var person02 = createPerson("Chandrika",27);
        log.info("equals {}",person01.equals(person02));// true
        log.info("== {}",person01==person02); // false , it compares the reference

        var person03 = person01.toBuilder()
                .setName("Sayan")
                .build();

        log.info("{}",person03);

        var person04 = person03.toBuilder()
                .clearName()
                .build();

        log.info("{}",person04); // throws null pointer exception if set to null
//        var person03 = Person.newBuilder()
//                .setName("XXXX")
//                .setAge(23)
//                .build();
//
//        log.info("{}",person03);
    }

    public static Person createPerson(String name,int age){
        return Person.newBuilder()
                .setName(name)
                .setAge(age)
                .build();
    }
}
