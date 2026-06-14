package com.dev.sayan.learncode.grpcproject.sec03;

import com.sayan.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec03SerializationAndDeserializationDemo {

    private static final Logger log = LoggerFactory.getLogger(Lec03SerializationAndDeserializationDemo.class);
    private static final Path path = Path.of("file.out");
    public static void main(String[] args) throws IOException {

        var person01 = Person.newBuilder()
                .setLastName("Sayan")
                .setAge(32)
                .setEmail("sayan@gmail.com")
                .setEmployed(true)
                .setSalary(23000.90)
                .setBankBalance(-1000)
                .setBankAccountNumber(12345678)
                .build();

        serilaize(person01);
        log.info("{}",deSerialize());

        log.info("{}",person01.equals(deSerialize()));




    }

    public static void serilaize(Person person){
        try(var stream = Files.newOutputStream(path)){
            person.writeTo(stream);
        }catch (Exception e){

        }

    }

    public static Person deSerialize() throws IOException {
        try(var stream = Files.newInputStream(path)){
            return Person.parseFrom(stream);
        }
    }
}
