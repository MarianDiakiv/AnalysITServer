package com.example.analysit.JsonModel;

import com.example.analysit.JsonModel.LanguageStatistics.LanguageCount;

import java.util.ArrayList;

public class CompanyCountVacancy implements Comparable<CompanyCountVacancy> {
    private String company;
    private Integer count;
    private ArrayList<LanguageCount> languageCounts;

    public CompanyCountVacancy(String company, Integer count) {
        this.company = company;
        this.count = count;
    }

    public CompanyCountVacancy(String company, Integer count, ArrayList<LanguageCount> languageCounts) {
        this.company = company;
        this.count = count;
        this.languageCounts = languageCounts;
    }

    public CompanyCountVacancy() {
        this.languageCounts  = new ArrayList<>();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<LanguageCount> getLanguageCounts() {
        return languageCounts;
    }

    public void setLanguageCounts(ArrayList<LanguageCount> languageCounts) {
        this.languageCounts = languageCounts;
    }

    @Override
    public String toString() {
        return "CompanyCountVacancy{" +
                "company='" + company + '\'' +
                ", count=" + count +
                ", languageCounts=" + languageCounts +
                '}';
    }

    @Override
    public int compareTo(CompanyCountVacancy o) {
        return this.count.compareTo(o.getCount());
    }
}
