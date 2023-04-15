package com.nikolastrapp.truco;

import com.nikolastrapp.truco.dtos.JogadorDto;
import com.nikolastrapp.truco.entities.Jogador;
import com.nikolastrapp.truco.mappers.JogadorMapper;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TrucoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrucoApplication.class, args);
    }

}
