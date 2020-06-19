package com.example.analysit.ParseData;

import java.io.Serializable;
import java.util.ArrayList;

public class VacancyDetails implements Serializable {
private String date;
ArrayList<String> listDetails;

    public VacancyDetails() {
        listDetails = new ArrayList<>();
    }
    public void addDetails(String str){
        listDetails.add(str);
    }
    public void addDetails(ArrayList<String> strings){
        for (String s :strings){
            this.listDetails.add(s);

        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<String> getListDetails() {
        return listDetails;
    }

    public void setListDetails(ArrayList<String> listDetails) {
        this.listDetails = listDetails;
    }

    @Override
    public String toString() {
        return "VacancyDetails{" +
                "date='" + date + '\'' +
                ", listDetails=" + listDetails +
                '}';
    }
}
