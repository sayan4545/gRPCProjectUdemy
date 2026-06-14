package com.dev.sayan.learncode.grpcproject.sec05;

import com.dev.sayan.learncode.grpcproject.sec05.parser.V1Parser;
import com.dev.sayan.learncode.grpcproject.sec05.parser.V2Parser;
import com.dev.sayan.learncode.grpcproject.sec05.parser.V3Parser;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sayan.models.sec05.v3.Television;
import com.sayan.models.sec05.v3.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V3VersionCompatibilty {

    private static final Logger log = LoggerFactory.getLogger(V3VersionCompatibilty.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("ONIDA")
                .setType(Type.HD)
                .build();

        V3Parser.parse(tv.toByteArray());
        V2Parser.parse(tv.toByteArray());
        V1Parser.parse(tv.toByteArray());
    }
}
