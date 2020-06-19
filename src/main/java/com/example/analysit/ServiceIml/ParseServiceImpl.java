package com.example.analysit.ServiceIml;

import com.example.analysit.EmailSender.SendEmail;
import com.example.analysit.FileWriter.*;
import com.example.analysit.JsonModel.LanguageStatistics.ConteinerLanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageStatistics;
import com.example.analysit.ParseData.Parsers;
import com.example.analysit.ParseData.Vacancy;
import com.example.analysit.ParseData.VacancyData;
import com.example.analysit.Service.ParseService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@Service
public class ParseServiceImpl implements ParseService {
    @Override
    public void paresData() {
        Parsers parsers = new Parsers();
        try {
        //java
          ArrayList<Vacancy> javadou =  parsers.parseDou("Java","https://jobs.dou.ua/vacancies/?category=Java&city=%D0%9B%D1%8C%D0%B2%D1%96%D0%B2");
            ArrayList<Vacancy> javadji =   parsers.parseDjinni("Java","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=Java");

            // С#
            ArrayList<Vacancy> chdou = parsers.parseDou(".NET","https://jobs.dou.ua/vacancies/?city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&category=.NET");
            ArrayList<Vacancy> chdji =  parsers.parseDjinni(".NET","https://djinni.co/jobs/?primary_keyword=.NET&location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");

            //php шось там з індексом пофіксити може справа суто у вакансії на сайті
            ArrayList<Vacancy> phpdou = parsers.parseDou("PHP","https://jobs.dou.ua/vacancies/?category=PHP&city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");
            ArrayList<Vacancy> phpdji =  parsers.parseDjinni("PHP","https://djinni.co/jobs/?primary_keyword=PHP&location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");

            // С++
            ArrayList<Vacancy> cppdou = parsers.parseDou("C++","https://jobs.dou.ua/vacancies/?city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&category=C%2B%2B");
            ArrayList<Vacancy> cppdji =  parsers.parseDjinni("C++","https://djinni.co/jobs/?primary_keyword=C%2B%2B&location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");

            // js
            ArrayList<Vacancy> jsdou = parsers.parseDou("Java script","https://jobs.dou.ua/vacancies/?city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&category=Node.js");
            ArrayList<Vacancy> jsdji =  parsers.parseDjinni("Java script","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=JavaScript");

            // python
            ArrayList<Vacancy> pythondou = parsers.parseDou("Python","https://jobs.dou.ua/vacancies/?city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&category=Python");
            ArrayList<Vacancy> pythonji =  parsers.parseDjinni("Python","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=Python");

            // ruby
            ArrayList<Vacancy> rubydou = parsers.parseDou("Ruby","https://jobs.dou.ua/vacancies/?city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&category=Ruby");
            ArrayList<Vacancy> rubynji =  parsers.parseDjinni("Ruby","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=Ruby");

            // android
            ArrayList<Vacancy> androiddou = parsers.parseDou("Android","https://jobs.dou.ua/vacancies/?category=Android&city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");
            ArrayList<Vacancy> androiddji =  parsers.parseDjinni("Android","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=Android");

            // data science
            ArrayList<Vacancy> dataddou = parsers.parseDou("Data science","https://jobs.dou.ua/vacancies/?category=Data+Science&city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");
            ArrayList<Vacancy> datadji =  parsers.parseDjinni("Data science","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=Data+Science");

            // goland go
            ArrayList<Vacancy> godou = parsers.parseDou("Goland","https://jobs.dou.ua/vacancies/?category=Golang&city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");
            ArrayList<Vacancy> godji =  parsers.parseDjinni("Goland","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=Golang");

            // ios
            ArrayList<Vacancy> iosdou = parsers.parseDou("IOS","https://jobs.dou.ua/vacancies/?category=iOS%2FmacOS&city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");
            ArrayList<Vacancy> iosdji =  parsers.parseDjinni("IOS","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=iOS");

            // qa
            ArrayList<Vacancy> qadou = parsers.parseDou("QA","https://jobs.dou.ua/vacancies/?category=QA&city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");
            ArrayList<Vacancy> qadji =  parsers.parseDjinni("QA","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=QA+Automation");

            // pm
            ArrayList<Vacancy> pmdou = parsers.parseDou("Project manager","https://jobs.dou.ua/vacancies/?category=Project+Manager&city=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2");
            ArrayList<Vacancy> pmdji =  parsers.parseDjinni("Project manager","https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=Project+Manager");


          System.out.println("Запис у список .........");
            VacancyData vacancyData = new VacancyData();
            vacancyData.addList(javadou);
            vacancyData.addList(javadji);

            vacancyData.addList(chdou);
            vacancyData.addList(chdji);

            vacancyData.addList(phpdji);
            vacancyData.addList(phpdou);

            vacancyData.addList(cppdou);
            vacancyData.addList(cppdji);

            vacancyData.addList(jsdou);
            vacancyData.addList(jsdji);

            vacancyData.addList(pythondou);
            vacancyData.addList(pythonji);

            vacancyData.addList(rubydou);
            vacancyData.addList(rubynji);

            vacancyData.addList(androiddou);
            vacancyData.addList(androiddji);

            vacancyData.addList(dataddou);
            vacancyData.addList(datadji);

            vacancyData.addList(godou);
            vacancyData.addList(godji);

            vacancyData.addList(iosdou);
            vacancyData.addList(iosdji);

            vacancyData.addList(qadou);
            vacancyData.addList(qadji);

            vacancyData.addList(pmdou);
            vacancyData.addList(pmdji);
          System.out.println("Вакансії ");
            for (Vacancy v:vacancyData.getVacancies()){
              System.out.println(v);
            }

          System.out.println("Початок запису даних у файл .........");

          //  перевірку на вакансії і назву компанії
            vacancyData.updateNameCompany();
            //запис вакансій у файл
            SerializeVacancy serializeVacancy = new SerializeVacancy();
          serializeVacancy.writeData(vacancyData);
          System.out.println("WRITED");
          System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                      //         створення і запис статистики у файл
            LanguageStatistics statistics = new LanguageStatistics();
            statistics = vacancyData.getStatictickByAllLanguage();
            ConteinerLanguageCount conteinerLanguageCount = new ConteinerLanguageCount();

          SerializeConteinerLanguageCount serializeConteinerLanguageCount = new SerializeConteinerLanguageCount();
//            // зчитуємо попереднє
            conteinerLanguageCount = serializeConteinerLanguageCount.readDataFromFile();
            // додаємо поточне
            conteinerLanguageCount.add(statistics);
            // записуємо
          serializeConteinerLanguageCount.writeData(conteinerLanguageCount);
            // запис у файл
//            FileDriver fileDriver =new FileDriver();
//            fileDriver.writeToFile(vacancyData);


            //         створення і запис статистики у файл
//            LanguageStatistics statistics = new LanguageStatistics();
//            statistics = vacancyData.getStatictickByAllLanguage();
//            ConteinerLanguageCount conteinerLanguageCount = new ConteinerLanguageCount();
//            conteinerLanguageCount.add(statistics);
//
//            FileDriverLanguageStatics fileDriverLanguageStatics = new FileDriverLanguageStatics();
//        fileDriverLanguageStatics.writeToFile(conteinerLanguageCount);

        // створення пдф
            FilePDFWriter filePDFWriter = new FilePDFWriter();
            filePDFWriter.writePdf();

            // відправлення повідомлень
          FileEmailWriter fileEmailWriter = new FileEmailWriter();
          Map<String,ArrayList<String>> map =  fileEmailWriter.getMap();
          Set<String> emails =  map.keySet();
          for (String  e :emails ) {
            SendEmail sendEmail = new SendEmail();
//            поміняти
            sendEmail.sendEmail(e, "на сайті http://localhost:4200/vacancy-list оновлення вакансій ");
          }



//

    }catch (Exception e ){
          System.out.println("Exeption PArseService");
          e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }
}
