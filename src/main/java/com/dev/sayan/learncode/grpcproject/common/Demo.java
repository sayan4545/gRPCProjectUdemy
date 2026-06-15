package com.dev.sayan.learncode.grpcproject.common;

import com.dev.sayan.learncode.grpcproject.sec06.BankService;

public class Demo {
    public static void main(String[] args) {
        GrpcServer server = GrpcServer.create(new BankService());
        server.start().await();
    }
}
