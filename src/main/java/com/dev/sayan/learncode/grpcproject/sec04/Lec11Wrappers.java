package com.dev.sayan.learncode.grpcproject.sec04;

import com.sayan.models.sec04.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11Wrappers {

    private static final Logger log = LoggerFactory.getLogger(Lec11Wrappers.class);

    public static void main(String[] args) {

        var sample = Sample.newBuilder().build();

        log.info("{}",sample.hasAge());
        log.info("{}",sample.hasName());
        log.info("{}",sample.hasLoginTime());

        //log.info("{}",Sample.getDefaultInstance());

    }
}
