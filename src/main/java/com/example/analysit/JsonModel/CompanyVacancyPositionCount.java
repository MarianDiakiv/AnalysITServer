package com.example.analysit.JsonModel;

import java.util.ArrayList;

public class CompanyVacancyPositionCount {
    private String company;
    private ArrayList<LanguagePosition> languagePositions;

    public CompanyVacancyPositionCount() {
        this.languagePositions = new ArrayList<>();
    }

    public CompanyVacancyPositionCount(String company, ArrayList<LanguagePosition> languagePositions) {
        this.company = company;
        this.languagePositions = languagePositions;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<LanguagePosition> getLanguagePositions() {
        return languagePositions;
    }

    public void setLanguagePositions(ArrayList<LanguagePosition> languagePositions) {
        this.languagePositions = languagePositions;
    }
    public void addLanhuahePosition(LanguagePosition position){
        this.languagePositions.add(position);
    }

    @Override
    public String toString() {
        return "CompanyVacancyLevelCount{" +
                "company='" + company + '\'' +
                ", languagePositions=" + languagePositions +
                '}';
    }
    /*контора
* список мов
* список рівнів
* кількіть */
}
