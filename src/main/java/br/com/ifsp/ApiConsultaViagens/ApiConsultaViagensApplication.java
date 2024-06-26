package br.com.ifsp.ApiConsultaViagens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.ifsp.ApiConsultaViagens")
public class ApiConsultaViagensApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiConsultaViagensApplication.class, args);
    }
}

