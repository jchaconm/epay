package com.itsight.epay;
import com.itsight.epay.domain.GeneralUser;
import com.itsight.epay.domain.TransactionSeller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EpayApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // TODO Auto-generated method stub
        return builder.sources(EpayApplication.class);
    }


    public static void main(String[] args) {
       SpringApplication.run(EpayApplication.class, args);
    /*
        GeneralUser generalUser = new GeneralUser();

        generalUser.setUsername("paolinho");
        generalUser.setEnabled(true);
        //generalUser.setId();
        generalUser.setPassword(new BCryptPasswordEncoder().encode("runfit123"));
    */
    }

}
