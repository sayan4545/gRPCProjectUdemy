package com.dev.sayan.learncode.grpcproject.sec05;

import com.dev.sayan.learncode.grpcproject.sec05.parser.V1Parser;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sayan.models.sec05.v1.Television;
import com.sayan.models.sec05.v1.Television;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V1VersionCompatibility {

    private static final Logger log = LoggerFactory.getLogger(V1VersionCompatibility.class);


    public static void main(String[] args) throws InvalidProtocolBufferException {

        var tv = Television.newBuilder()
                .setBrand("Samsung")
                .setYear(2026)
                .build();

        V1Parser.parse(tv.toByteArray());

    }
}
