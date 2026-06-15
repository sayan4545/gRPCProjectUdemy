package com.dev.sayan.learncode.grpcproject.common;
import com.dev.sayan.learncode.grpcproject.BankService;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        var server = ServerBuilder.forPort(8888)
                .addService(new BankService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
