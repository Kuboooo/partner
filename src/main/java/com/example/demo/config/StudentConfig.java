package com.example.demo.config;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            StudentEntity tester = new StudentEntity(
                    "Tester",
                    "tester@mail.cz",
                    LocalDate.of(2000, Month.JANUARY, 20),
                    21
            );
            StudentEntity adam = new StudentEntity(
                    "Adam",
                    "adam@mail.cz",
                    LocalDate.of(2002, Month.FEBRUARY, 10),
                    12
            );
            studentRepository.saveAll(
                    List.of(tester, adam)
            );
        };
    }
}
