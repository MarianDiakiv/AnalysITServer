package com.example.analysit.Service;

import com.example.analysit.JsonModel.CompanyCountVacancy;
import com.example.analysit.JsonModel.CompanyVacancyPositionCount;
import com.example.analysit.JsonModel.LanguageStatistics.ConteinerLanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageStatistics;

import java.util.ArrayList;

public interface StatisticsService {
    LanguageStatistics getStatisticsByNowTime();
    ConteinerLanguageCount getStatisticsAll();
    ArrayList<CompanyCountVacancy> getCountVacancyByCompany();
    ArrayList<CompanyVacancyPositionCount> getCompanyVacancyPositionCount();
    LanguageStatistics getUserInterestings();
    CompanyVacancyPositionCount getInfoAboutCompany(String company);
    ArrayList<CompanyVacancyPositionCount> getInfoAboutAllCompany();

}
