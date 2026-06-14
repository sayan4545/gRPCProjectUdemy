package com.dev.sayan.learncode.grpcproject.sec05;

import com.dev.sayan.learncode.grpcproject.sec05.parser.V1Parser;
import com.dev.sayan.learncode.grpcproject.sec05.parser.V2Parser;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sayan.models.sec05.v2.Television;
import com.sayan.models.sec05.v2.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V2VersionCompatibilty {
    private static final Logger log = LoggerFactory.getLogger(V2VersionCompatibilty.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {

        var tv = Television.newBuilder()
                .setBrand("SONY")
                .setModel(3456)
                .setType(Type.OLED)
                .build();

        V2Parser.parse(tv.toByteArray());
        log.info("For Television version 01 ..");
        V1Parser.parse(tv.toByteArray());

    }
}
