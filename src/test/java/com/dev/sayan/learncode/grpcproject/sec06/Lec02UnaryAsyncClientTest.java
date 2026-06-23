package com.dev.sayan.learncode.grpcproject.sec06;

import com.dev.sayan.learncode.grpcproject.common.ResponseServer;
import com.sayan.models.sec06.Account_balance;
import com.sayan.models.sec06.balanceCheckRequest;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class Lec02UnaryAsyncClientTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(Lec02UnaryAsyncClientTest.class);

    @Test
    public void balanceTest() throws InterruptedException {
        var request = balanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var observer = ResponseServer.<Account_balance>create();
        this.asyncStub.calculateAccountBalance(request,observer);
        observer.await();
        Assertions.assertEquals(1,observer.getResults().size());
        Assertions.assertEquals(100,observer.getResults().getFirst().getBalance());

    }
}
