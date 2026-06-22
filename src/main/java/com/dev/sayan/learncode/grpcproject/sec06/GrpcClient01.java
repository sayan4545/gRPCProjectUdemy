package com.dev.sayan.learncode.grpcproject.sec06;

import com.sayan.models.sec06.Account_balance;
import com.sayan.models.sec06.BankServiceGrpc;
import com.sayan.models.sec06.balanceCheckRequest;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClient01 {

    private static final Logger log = LoggerFactory.getLogger(GrpcClient01.class);
    public static void main(String[] args) {

        var channel = ManagedChannelBuilder
                .forAddress("localhost",6000)
                .usePlaintext()
                .build();

//        var fakeService = BankServiceGrpc.newBlockingStub(channel);
//        var balanceResult = fakeService.calculateAccountBalance(balanceCheckRequest.newBuilder()
//                .setAccountNumber(8).build());
//
//        log.info("{}",balanceResult);
        var asyncStub = BankServiceGrpc.newStub(channel);
        asyncStub.calculateAccountBalance(balanceCheckRequest.newBuilder().setAccountNumber(2).build(), new StreamObserver<Account_balance>() {
            @Override
            public void onNext(Account_balance value) {
                log.info("{}",value);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                log.info("completed");

            }
        });

        log.info("done");
        try{
            Thread.sleep(100000);
        }catch (InterruptedException e){
            log.info("Interrupted");
        }



    }
}
