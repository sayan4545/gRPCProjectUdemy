package com.dev.sayan.learncode.grpcproject.sec03;

import com.sayan.models.sec03.Credentials;
import com.sayan.models.sec03.Email;
import com.sayan.models.sec03.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec09OneOf {

    private static final Logger log = LoggerFactory.getLogger(Lec09OneOf.class);

    public static void main(String[] args) {

        var email = Email.newBuilder()
                .setEmail("sayan@gmail.com")
                .setPassword("asssghgh")
                .build();
        var phone = Phone.newBuilder()
                .setPhone(877701)
                .setCode(1234)
                .build();

        login(Credentials.newBuilder().setEmail(email).build());
        login(Credentials.newBuilder().setPhone(phone).build());
        login(Credentials.newBuilder().setPhone(phone).setEmail(email).build());
        login(Credentials.newBuilder().setEmail(email).setPhone(phone).build());

    }
    public static void login(Credentials credentials){
        switch (credentials.getLoginTypeCase()){
            case EMAIL -> log.info("email : {}",credentials.getEmail());
            case PHONE -> log.info("phone : {}",credentials.getPhone());
        }
    }
}
