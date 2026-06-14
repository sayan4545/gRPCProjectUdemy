package com.dev.sayan.learncode.grpcproject;

import com.sayan.models.sec06.Account_balance;
import com.sayan.models.sec06.BankServiceGrpc;
import com.sayan.models.sec06.balanceCheckRequest;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void calculateAccountBalance(balanceCheckRequest request, StreamObserver<Account_balance> responseObserver) {

        var accountNumber = request.getAccountNumber();
        var accountBalance = Account_balance
                .newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(accountNumber*3)
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();

    }
}
