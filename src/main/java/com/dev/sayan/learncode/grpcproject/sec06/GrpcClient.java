package com.dev.sayan.learncode.grpcproject.sec06;

import com.sayan.models.sec06.BankServiceGrpc;
import com.sayan.models.sec06.balanceCheckRequest;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClient {
    private static final Logger log = LoggerFactory.getLogger(GrpcClient.class);
    public static void main(String[] args) {

        var channel = ManagedChannelBuilder.forAddress("localhost",6000)
                .usePlaintext()
                .build();

        var stub = BankServiceGrpc.newBlockingStub(channel);

        var balance = stub.calculateAccountBalance(balanceCheckRequest.newBuilder()
                .setAccountNumber(3).build());

        log.info("{}",balance);

    }
}
