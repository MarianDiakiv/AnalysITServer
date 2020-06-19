package com.example.analysit;

import com.example.analysit.FileWriter.*;
import com.example.analysit.JsonModel.LanguageStatistics.ConteinerLanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageStatistics;
import com.example.analysit.ParseData.Parsers;

import com.example.analysit.ParseData.Vacancy;
import com.example.analysit.ParseData.VacancyData;
import com.example.analysit.ServiceIml.ParseServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
@EnableScheduling
public class AnalysitApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalysitApplication.class, args);
        Parsers parsers = new Parsers();

    }


    @Scheduled(fixedDelay = 259200000)//3 дні
public void SheduledTask(){

//        ParseServiceImpl parseService = new ParseServiceImpl();
//        parseService.paresData();
}

}
