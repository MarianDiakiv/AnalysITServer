package com.example.analysit.Controller;

import com.example.analysit.EmailSender.SendEmail;
import com.example.analysit.FileWriter.FileEmailWriter;
import com.example.analysit.ParseData.Vacancy;
import com.example.analysit.ParseData.VacancyData;
import com.example.analysit.Service.ParseService;
import com.example.analysit.Service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

@RestController
public class MainController {
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private ParseService parseService;


    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<Vacancy> getAllVacancy(){
        ArrayList<Vacancy> vacancies = vacancyService.getAllVacancy().getVacancies();
        return  vacancies;
}
@GetMapping("/language/{language}")
@CrossOrigin(origins = "http://localhost:4200")
public ArrayList<Vacancy> getOnlyOneLanguage(@PathVariable("language") String lang){
        VacancyData vacancyData = vacancyService.getAllVacancy();
         ArrayList<Vacancy> list = (ArrayList<Vacancy>) vacancyData.getVacanciesByLanguage(lang);
         return list;
}
@GetMapping("/id/{id}")
@CrossOrigin(origins = "http://localhost:4200")
public  Vacancy getById(@PathVariable("id") int id){
return  vacancyService.getById(id);
}

    @GetMapping("/site/dou")
    @CrossOrigin(origins = "http://localhost:4200")
ArrayList<Vacancy> getVacancyBySitedou(){
        return vacancyService.getBySite("dou");
}
    @GetMapping("/site/gjinni")
    @CrossOrigin(origins = "http://localhost:4200")
    ArrayList<Vacancy> getVacancyBySitegjinni(){
        return vacancyService.getBySite("gjinni");
    }
    @GetMapping("/allLanguage")
    @CrossOrigin(origins = "http://localhost:4200")
    ArrayList<String> getAlllanguage(){
        return vacancyService.getAllLanguage();
    }

    @GetMapping("/company/{company}")
    @CrossOrigin(origins = "http://localhost:4200")
    ArrayList<Vacancy> getVacancyByCompany(@PathVariable("company") String company){
return vacancyService.getByCompanyName(company);
    }


    @PostMapping("/subscribe/{mail}")
    @CrossOrigin(origins = "http://localhost:4200")
    void subscribe(@PathVariable("mail") String mail, @RequestBody ArrayList<String> list){
        try {
            FileEmailWriter fileEmailWriter = new FileEmailWriter();
            Map<String,ArrayList<String>> map = fileEmailWriter.getMap();
            map.put(mail,list);
            fileEmailWriter.rewriteFile(map);

//            map.put(mail,)
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @PostMapping("/canselsubscribe")
    @CrossOrigin(origins = "http://localhost:4200")
    public String cansecSubscribe(@RequestBody String email){
//        скасування підписки

        try {
            FileEmailWriter fileEmailWriter = new FileEmailWriter();
            Map<String, ArrayList<String>> map = fileEmailWriter.getMap();
            if (!map.containsKey(email)){
                return "Даний емейл не зареєстрований";
            }else {
                map.remove(email);
                fileEmailWriter.rewriteFile(map);
                SendEmail sendEmail = new SendEmail();
                sendEmail.sendEmail(email, "Ви відписались від повідомлень");
            }
        }catch (IOException e ){
            System.out.println(e.getMessage());
        }
        return "Підписку скасовано";
    }





    @GetMapping("/parseVacancy")
    @CrossOrigin(origins = "http://localhost:4200")
    public void parseVacancy(){
        this.parseService.paresData();
    }
    @GetMapping("/allCompanyName")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<String> getAllComapny(){
        return this.vacancyService.getCompanyName();
    }
    @GetMapping("/alllanguageByCompany/{company}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<String> getAllLanguageBuCompany(@PathVariable("company") String company){
        return this.vacancyService.getLanguageByCompany(company);
    }
    @GetMapping("/allPositionByCompanyLanguage/{company}/{language}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<String> getAllPositionByCompanyAndLanguage(@PathVariable("company") String company,@PathVariable("language") String language){
        return this.vacancyService.getPositionByCompanyandLanguage(company,language);
    }
    @GetMapping("/allVacancyByCompanyLanguagePosition/{company}/{language}/{position}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<Vacancy> getAllVacancyByCompanyAndLanguageAndPosition(@PathVariable("company") String company,
                                                                @PathVariable("language") String language,
                                                                @PathVariable("position") String position){

        return this.vacancyService.getVacancyByCompanyLanguagePosition(company,language,position);
    }


}


