package com.example.analysit.ServiceIml;

import com.example.analysit.FileWriter.*;
import com.example.analysit.JsonModel.CompanyCountVacancy;
import com.example.analysit.JsonModel.CompanyVacancyPositionCount;
import com.example.analysit.JsonModel.LanguageStatistics.ConteinerLanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageStatistics;
import com.example.analysit.ParseData.VacancyData;
import com.example.analysit.Service.StatisticsService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public LanguageStatistics getStatisticsByNowTime() {
        LanguageStatistics statistics = new LanguageStatistics();
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//
//        }catch (Exception e){
//            System.out.println("EXEPTION IN StatisticsServiceImpl  Method getStatisticsByNowTime");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        statistics = vacancyData.getStatictickByAllLanguage();
        statistics.sort();
        return statistics;
    }

    @Override
    public ConteinerLanguageCount getStatisticsAll() {
        ConteinerLanguageCount conteinerLanguageCount = new ConteinerLanguageCount();
//        try {
//            FileDriverLanguageStatics fileDriverLanguageStatics = new FileDriverLanguageStatics();
//            conteinerLanguageCount = fileDriverLanguageStatics.getConteinerLanguageCount();
//
//        }catch (IOException e){
//            System.out.println("EXEPTION IN StatisticsServiceImpl  Method ConteinerLanguageCount");
//            System.out.println(e.getMessage());
//
//        }
        SerializeConteinerLanguageCount serializeConteinerLanguageCount = new SerializeConteinerLanguageCount();
        conteinerLanguageCount = serializeConteinerLanguageCount.readDataFromFile();
        return conteinerLanguageCount;
    }

    @Override
    public ArrayList<CompanyCountVacancy> getCountVacancyByCompany() {
//        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver  = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//        }catch (Exception ex){
//            System.out.println("EXEPTION IN VacancyServiceImpl  MEthod getAllVacancy");
//        }
//        ArrayList<CompanyCountVacancy> list  = vacancyData.getCountVacancyByCompany();
//        ArrayList<CompanyCountVacancy> top = new ArrayList<>();
//        top.addAll(list.subList(0,10));
//        return top;
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver  = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//        }catch (Exception ex){
//            System.out.println("EXEPTION IN VacancyServiceImpl  MEthod getAllVacancy");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        ArrayList<CompanyCountVacancy> top  = vacancyData.getTopCompanies();

        return top;

    }

    @Override
    public ArrayList<CompanyVacancyPositionCount> getCompanyVacancyPositionCount() {
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver  = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//        }catch (Exception ex){
//            System.out.println("EXEPTION IN VacancyServiceImpl  MEthod getAllVacancy");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        ArrayList<CompanyVacancyPositionCount> list = vacancyData.getVacancyByCompanyLanguagePosition();
        return list;
    }

    @Override
    public LanguageStatistics getUserInterestings() {
        LanguageStatistics languageStatistics = new LanguageStatistics();
        try {

            LanguageCount java = new LanguageCount();
            java.setLanguage("Java");
            java.setCount(0);
            LanguageCount net = new LanguageCount();
            net.setLanguage(".NET");
            net.setCount(0);
            LanguageCount php = new LanguageCount();
            php.setLanguage("PHP");
            php.setCount(0);
            LanguageCount cpp = new LanguageCount();
            cpp.setLanguage("C++");
            cpp.setCount(0);
            LanguageCount javaScript = new LanguageCount();
            javaScript.setLanguage("Java Script");
            javaScript.setCount(0);
            LanguageCount python = new LanguageCount();
            python.setLanguage("Python");
            python.setCount(0);
            LanguageCount ruby = new LanguageCount();
            ruby.setLanguage("Ruby");
            ruby.setCount(0);
            LanguageCount android = new LanguageCount();
            android.setLanguage("Android");
            android.setCount(0);
            LanguageCount datasciece = new LanguageCount();
            datasciece.setLanguage("Data Science");
            datasciece.setCount(0);
            LanguageCount golang = new LanguageCount();
            golang.setLanguage("Golang");
            golang.setCount(0);
            LanguageCount ios = new LanguageCount();
            ios.setLanguage("IOS");
            ios.setCount(0);
            LanguageCount qa = new LanguageCount();
            qa.setLanguage("QA");
            qa.setCount(0);
            LanguageCount pm = new LanguageCount();
            pm.setLanguage("Project manager");
            pm.setCount(0);

            FileEmailWriter fileEmailWriter = new FileEmailWriter();
            Map<String,ArrayList<String>> map = fileEmailWriter.getMap();
            Set setMap = map.entrySet();
            Iterator iterator = setMap.iterator();
            while (iterator.hasNext()){
                Map.Entry me = (Map.Entry) iterator.next();
                String key = (String) me.getKey();
                ArrayList<String> list = (ArrayList<String>) me.getValue();

                for (String s:list) {
                    if (s.equals("Java")){
                        java.setCount(java.getCount()+1);
                    }else  if (s.equals(".NET")){
                        net.setCount(net.getCount()+1);
                    }else if(s.equals("PHP")){
                        php.setCount(php.getCount()+1);
                    }else if(s.equals("C++")){
                        cpp.setCount(cpp.getCount()+1);
                    }else if(s.equals("Java Script")){
                        javaScript.setCount(javaScript.getCount()+1);
                    }else if(s.equals("Python")){
                        python.setCount(python.getCount()+1);
                    }else if(s.equals("Ruby")){
                        ruby.setCount(ruby.getCount()+1);
                    }else if(s.equals("Android")){
                        android.setCount(android.getCount()+1);
                    }else if(s.equals("Data Science")){
                        datasciece.setCount(datasciece.getCount()+1);
                    }else if(s.equals("Goland")){
                        golang.setCount(golang.getCount()+1);
                    }else if(s.equals("IOS")){
                        ios.setCount(ios.getCount()+1);
                    }else if(s.equals("QA")){
                        qa.setCount(qa.getCount()+1);
                    }else if(s.equals("Project Manager")){
                        pm.setCount(pm.getCount()+1);
                    }else {
                        System.out.println("EROR getUserInterestings + "+ s);
                    }
                }
            }
            ArrayList<LanguageCount> languageCounts = new ArrayList<>();
            languageCounts.add(java);
            languageCounts.add(net);
            languageCounts.add(php);
            languageCounts.add(cpp);
            languageCounts.add(javaScript);
            languageCounts.add(python);
            languageCounts.add(ruby);
            languageCounts.add(android);
            languageCounts.add(datasciece);
            languageCounts.add(golang);
            languageCounts.add(ios);
            languageCounts.add(qa);
            languageCounts.add(pm);


            languageStatistics.setCountArrayList(languageCounts);
            languageStatistics.sort();



        }catch (IOException e ){
            System.out.println(e.getMessage());
        }
        return languageStatistics;
    }

    @Override
    public CompanyVacancyPositionCount getInfoAboutCompany(String company) {
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver  = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//        }catch (Exception ex){
//            System.out.println("EXEPTION IN VacancyServiceImpl  Method getInfoAboutCompany");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        CompanyVacancyPositionCount companyVacancyPositionCount = vacancyData.getDetailInfoAboutCompany(company);
        return companyVacancyPositionCount;
    }

    @Override
    public ArrayList<CompanyVacancyPositionCount> getInfoAboutAllCompany() {
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver  = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//        }catch (Exception ex){
//            System.out.println("EXEPTION IN VacancyServiceImpl  Method getInfoAboutCompany");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        ArrayList<CompanyVacancyPositionCount> companyVacancyPositionCountList = vacancyData.getDetailInfoAboutAllCompany();
        return companyVacancyPositionCountList;
    }
}
