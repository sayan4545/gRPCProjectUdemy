package com.dev.sayan.learncode.grpcproject.sec06;

import com.sayan.models.sec06.balanceCheckRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01UnaryBlockingClientTest extends AbstractTest {
    private static final Logger log = LoggerFactory.getLogger(Lec01UnaryBlockingClientTest.class);

        @Test
        public void accountBalanceTest(){
            var request = balanceCheckRequest.newBuilder()
                    .setAccountNumber(1)
                    .build();
            var balance = this.blockingStub.calculateAccountBalance(request);
            log.info("{}",balance);
            Assertions.assertEquals(100,balance.getBalance());
        }




}
