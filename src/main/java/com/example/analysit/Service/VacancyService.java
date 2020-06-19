package com.example.analysit.Service;

import com.example.analysit.ParseData.Vacancy;
import com.example.analysit.ParseData.VacancyData;

import java.util.ArrayList;

public interface VacancyService {
     VacancyData getAllVacancy();
      Vacancy getById(int id);
    ArrayList<Vacancy> getBySite(String site);
    ArrayList<String> getAllLanguage();
    ArrayList<Vacancy> getByCompanyName(String comapany);
    ArrayList<String> getCompanyName();
    ArrayList<String> getLanguageByCompany(String company);
    ArrayList<String> getPositionByCompanyandLanguage(String company, String language);
    ArrayList<Vacancy> getVacancyByCompanyLanguagePosition(String company,String language,String position);
}
