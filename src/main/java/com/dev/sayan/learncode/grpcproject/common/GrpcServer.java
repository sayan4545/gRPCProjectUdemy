package com.dev.sayan.learncode.grpcproject.common;
import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class GrpcServer {

    private static final Logger log = LoggerFactory.getLogger(GrpcServer.class);

    private final Server server ;

    private GrpcServer(Server server){
        this.server = server;
    }
    public static GrpcServer create(BindableService... services){
        return create(6000,services);
    }
    public static GrpcServer create(int port, BindableService... services){
        var builder = ServerBuilder.forPort(port);
        Arrays.asList(services)
                .forEach(builder::addService);
        return new GrpcServer(builder.build());

    }
    public  GrpcServer start(){
        var services = server.getServices()
                .stream()
                .map(ServerServiceDefinition::getServiceDescriptor)
                .map(ServiceDescriptor::getName)
                .toList();
        try {
            server.start();
            log.info("server started . listenning at port {}. service : {}",server.getPort(),services);
            return this;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
    public void await(){
        try{
            server.awaitTermination();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
    public void stop(){
        server.shutdown();
        log.info("server shutdown");
    }



}
