package com.nikolastrapp.truco;

import com.nikolastrapp.truco.entities.*;
import com.nikolastrapp.truco.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class TrucoApplication {


    public static void main(String[] args) {
        SpringApplication.run(TrucoApplication.class, args);
    }

}
