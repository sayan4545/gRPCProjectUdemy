package com.dev.sayan.learncode.grpcproject.sec03;

public record JsonPerson(String last_name
        ,int age
        ,Boolean employed
        ,String email
        ,Double salary
        ,Long bankAccountNumber
        ,Long balance) {
}
