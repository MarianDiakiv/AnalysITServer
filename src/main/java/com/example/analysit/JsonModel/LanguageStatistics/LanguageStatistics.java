package com.example.analysit.JsonModel.LanguageStatistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class LanguageStatistics implements Serializable {
    String data;
    private ArrayList<LanguageCount> countArrayList;

    public LanguageStatistics(ArrayList<LanguageCount> countArrayList) {
        this.countArrayList = countArrayList;
    }

    public LanguageStatistics() {
        this.countArrayList = new ArrayList<>();
    }
    public  void add(LanguageCount count){
        this.countArrayList.add(count);

    }

    public ArrayList<LanguageCount> getCountArrayList() {
        return countArrayList;
    }

    public void setCountArrayList(ArrayList<LanguageCount> countArrayList) {
        this.countArrayList = countArrayList;
    }
    public void sort(){
        Collections.sort(countArrayList, Collections.reverseOrder());
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
//    @Override
//    public String toString() {
//        return "LanguageStatistics{" +
//                "countArrayList=" + countArrayList +
//                '}';
//    }

    @Override
    public String toString() {
        return "LanguageStatistics{" +
                "data='" + data + '\'' +
                ", countArrayList=" + countArrayList +
                '}';
    }
}
