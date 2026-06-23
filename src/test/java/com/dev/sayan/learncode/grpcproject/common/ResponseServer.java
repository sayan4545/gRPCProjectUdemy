package com.dev.sayan.learncode.grpcproject.common;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ResponseServer <T> implements StreamObserver<T> {

    private static final Logger log = LoggerFactory.getLogger(ResponseServer.class);
    private final List<T> list = Collections.synchronizedList(new ArrayList<>());
    private Throwable throwable;
    private final CountDownLatch countDownLatch;

    private ResponseServer(int count){
        this.countDownLatch = new CountDownLatch(count);
    }

    public static <T> ResponseServer<T> create(){
        return new ResponseServer<>(1);
    }
    public static <T> ResponseServer<T> create(int countDown){
        return new ResponseServer<>(countDown);
    }
    @Override
    public void onNext(T value) {
        log.info("recieved item : {}",value);
        this.list.add(value);
    }
    @Override
    public void onError(Throwable t) {
        log.info("recievederor : {}",t.getMessage());
        this.throwable = t;
        this.countDownLatch.countDown();
    }
    @Override
    public void onCompleted() {
        this.countDownLatch.countDown();
    }

    public void await(){
        try{
            this.countDownLatch.await(5, TimeUnit.SECONDS);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<T> getResults(){
        return this.list;
    }


}
