package com.dev.sayan.learncode.grpcproject.sec03;

import com.sayan.models.sec03.BodyStyle;
import com.sayan.models.sec03.Car;
import com.sayan.models.sec03.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec07MapDemo {

    private static final Logger log = LoggerFactory.getLogger(Lec07MapDemo.class);
    public static void main(String[] args) {

        var car01 = Car.newBuilder()
                .setMake("Tata")
                .setModel("Tiago")
                .setYear(2026)
                .setBodyStyle(BodyStyle.HATCHBACK)
                .build();

        var car02 = Car.newBuilder()
                .setMake("Mahindra")
                .setModel("Thar")
                .setYear(2021)
                .setBodyStyle(BodyStyle.SUV)
                .build();

        var dealer01 = Dealer
                .newBuilder()
                .putInventory(car01.getYear(), car01)
                .putInventory(car02.getYear(), car02)
                .build();

//        log.info("dealer : {}",dealer01);
//        log.info("{}",dealer01.containsInventory(car02.getYear()));
//        log.info("{}",dealer01.containsInventory(2021));
//
//        log.info("{}",dealer01.containsInventory(2020));
//
//        log.info("{}",dealer01.containsInventory(2100));
        log.info("{}",dealer01.getInventoryOrThrow(2021).getModel());

        log.info("{},{},{}"
                ,dealer01.getInventoryOrThrow(2021)
                        .getBodyStyle()
                ,dealer01.getInventoryOrThrow(2021)
                        .getModel()
                ,dealer01.getInventoryOrThrow(2021)
                        .getMake());



    }
}
