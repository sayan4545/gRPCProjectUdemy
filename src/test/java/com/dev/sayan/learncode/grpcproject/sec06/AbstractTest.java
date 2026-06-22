package com.dev.sayan.learncode.grpcproject.sec06;

import com.dev.sayan.learncode.grpcproject.common.AbstractChannelTest;
import com.dev.sayan.learncode.grpcproject.common.GrpcServer;
import com.sayan.models.sec06.BankServiceGrpc;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractTest extends AbstractChannelTest {

    private final GrpcServer grpcServer = GrpcServer.create(new BankService());

    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;

    @BeforeAll
    public void setup(){
        this.grpcServer.start();
        this.blockingStub = BankServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }
}
