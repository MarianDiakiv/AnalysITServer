package com.example.analysit.JsonModel;

import java.util.ArrayList;

public class LanguagePosition {
    private String language;
    private ArrayList<PositionCount> positionCounts;

    public LanguagePosition() {
        this.positionCounts = new ArrayList<>();
    }

    public LanguagePosition(String language, ArrayList<PositionCount> positionCounts) {
        this.language = language;
        this.positionCounts = positionCounts;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<PositionCount> getPositionCounts() {
        return positionCounts;
    }

    public void setPositionCounts(ArrayList<PositionCount> positionCounts) {
        this.positionCounts = positionCounts;
    }
    public void addPositionsCount(PositionCount count){
        this.positionCounts.add(count);
    }
    public void addPositionCount(PositionCount count){
        positionCounts.add(count);
    }

    @Override
    public String toString() {
        return "LanguagePosition{" +
                "language='" + language + '\'' +
                ", positionCounts=" + positionCounts +
                '}';
    }
}
