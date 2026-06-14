package com.dev.sayan.learncode.grpcproject.sec03;

import com.sayan.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.ObjectMapper;

public class Lec03PerformanceTest {

    private static final Logger log = LoggerFactory.getLogger(Lec03PerformanceTest.class);
    private static  final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        var protoPerson = Person
                .newBuilder()
                .setLastName("sayan")
                .setAge(27)
                .setEmail("sayan@gmail.com")
                .setEmployed(true)
                .setBankBalance(-10000)
                .setSalary(2345.8989)
                .setBankAccountNumber(12345678l)
                .build();

        var jsonPerson =
                new JsonPerson("sayan",27,true,"sayan@gmail.com"
                ,2345.8989,12345678l,-10000l);

        JsonPerson(jsonPerson);
        ProtoPerson(protoPerson);

//        for(int i =0;i<5;i++){
//            test("json",()->JsonPerson(jsonPerson));
//            test("proto",()->ProtoPerson(protoPerson));
//        }

    }
    public static void ProtoPerson(Person person){
        try{
            var bytes = person.toByteArray();
            log.info("proto bytes length : {}",bytes.length);
            Person.parseFrom(bytes);
        } catch(Exception e){
            throw new RuntimeException(e);
        }

    }
    public static void JsonPerson(JsonPerson jsonPerson){
        try{
            var bytes = mapper.writeValueAsBytes(jsonPerson);
            log.info("json bytes length : {}",bytes.length);
            mapper.readValue(bytes,JsonPerson.class);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    public static void test(String testName,Runnable runnable){
        var start = System.currentTimeMillis();

        for(int i =0; i<10_00_0000;i++){
            runnable.run();
        }
        var end = System.currentTimeMillis();
        log.info("time taken for {} - {} ms",testName,end-start);
    }
}
