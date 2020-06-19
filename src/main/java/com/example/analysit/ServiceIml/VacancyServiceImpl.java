package com.example.analysit.ServiceIml;

import com.example.analysit.FileWriter.SerializeVacancy;
import com.example.analysit.ParseData.Vacancy;
import com.example.analysit.ParseData.VacancyData;
import com.example.analysit.Service.VacancyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class VacancyServiceImpl implements VacancyService {
    @Override
    public VacancyData getAllVacancy() {
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver  = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//        }catch (Exception ex){
//            System.out.println("EXEPTION IN VacancyServiceImpl  MEthod getAllVacancy");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();

        return vacancyData;
    }

    @Override
    public Vacancy getById(int id) {
        VacancyData vacancyData = new VacancyData();
        Vacancy vacancy = new Vacancy();
//        try {
//            FileDriver fileDriver  = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//            vacancy = vacancyData.getByID(id);
//        }catch (Exception ex){
//            System.out.println("EXEPTION IN VacancyServiceImpl  Mthod getById");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        vacancy = vacancyData.getByID(id);


        return vacancy;
    }
    public ArrayList<Vacancy> getBySite(String site){
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//
//        }catch (Exception e){
//            System.out.println("EXEPTION IN VacancyServiceImpl  Method getBySite");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        ArrayList<Vacancy> vac = vacancyData.getBySite(site);
        return vac;
    }

    @Override
    public ArrayList<String> getAllLanguage() {
        ArrayList<String> list = new ArrayList<>();
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//
//        }catch (Exception e){
//            System.out.println("EXEPTION IN VacancyServiceImpl  Method getAllLanguage");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        list = vacancyData.getAllLAnguage();
        return list;
    }

    @Override
    public ArrayList<Vacancy> getByCompanyName(String comapany) {
        ArrayList<Vacancy> list = new ArrayList<>();
        VacancyData vacancyData = new VacancyData();
//        try {
//            FileDriver fileDriver = new FileDriver();
//            vacancyData = fileDriver.getVacancyData();
//
//        }catch (Exception ex){
//            System.out.println("EXEPTION IN VacancyServiceImpl  Method getByCompanyName");
//        }
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        list = (ArrayList<Vacancy>) vacancyData.getVacancyByCompany(comapany);
        return list;
    }

    @Override
    public ArrayList<String> getCompanyName() {
        VacancyData vacancyData = new VacancyData();
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        ArrayList<String> list = vacancyData.getAllCompany();
        return list;
    }

    @Override
    public ArrayList<String> getLanguageByCompany(String company) {
        VacancyData vacancyData = new VacancyData();
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        ArrayList<Vacancy> vacancies = vacancyData.getVacancies();
        ArrayList<String>  langList = new ArrayList<>();

        for (Vacancy v:vacancies){
            if (v.getCompany().equals(company)){
                if (langList.size()>0){
                    boolean exist = false;
                    for (String s :langList){
                        if (s.equals(v.getLanguage())){
                            exist=true;
                        }
                    }
                    if (exist==false){
                        langList.add(v.getLanguage());
                    }
                }else {
                    langList.add(v.getLanguage());
                }
            }
        }
        return langList;
    }

    @Override
    public ArrayList<String> getPositionByCompanyandLanguage(String company, String language) {
        VacancyData vacancyData = new VacancyData();
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        ArrayList<Vacancy> vacancies = vacancyData.getVacancies();
        ArrayList<String>  positionList = new ArrayList<>();
        for (Vacancy v:vacancies){
            if (v.getCompany().equals(company)&&v.getLanguage().equals(language)){
                if (positionList.size()>0){
                    boolean exist = false;
                    for (String s:positionList){
                        if (s.equals(v.getPosition())){
                            exist = true;
                        }
                    }
                    if (exist==false){
                        positionList.add(v.getPosition());
                    }
                }else {
                    positionList.add(v.getPosition());
                }
            }
        }
        return positionList;
    }

    @Override
    public ArrayList<Vacancy> getVacancyByCompanyLanguagePosition(String company, String language, String position) {
        VacancyData vacancyData = new VacancyData();
        SerializeVacancy serializeVacancy = new SerializeVacancy();
        vacancyData = serializeVacancy.readVacancyData();
        ArrayList<Vacancy> vacancies = vacancyData.getVacancies();
        ArrayList<Vacancy>  vacancyList = new ArrayList<>();
        for (Vacancy v:vacancies){
            if (v.getCompany().equals(company)&&v.getLanguage().equals(language)&&v.getPosition().equals(position)){
                vacancyList.add(v);
                System.out.println(v);
            }
        }
//        System.out.println();
        return vacancyList;
    }
}
