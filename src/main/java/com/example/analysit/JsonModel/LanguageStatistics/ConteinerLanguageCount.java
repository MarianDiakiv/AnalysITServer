package com.example.analysit.JsonModel.LanguageStatistics;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ConteinerLanguageCount implements Serializable {
    private ArrayList<LanguageStatistics> countLanguageList;

    public ConteinerLanguageCount(ArrayList<LanguageStatistics> countLanguageList) {
        this.countLanguageList = countLanguageList;
    }

    public ConteinerLanguageCount() {
        this.countLanguageList = new ArrayList<>();
    }
    public void add(LanguageStatistics statistics){
//        String data ="";
//        Date data1 = new Date();
//        int month = data1.getMonth()+1;
//        data = ""+data1.getDate()+"."+month+1+"."+data1.getYear();
//
//        statistics.setData(data);
        // статистика лише із 5 останніх вибірок
        if (this.countLanguageList.size()<5){
            this.countLanguageList.add(statistics);
        }else {
            removeFirstElement();
            this.countLanguageList.add(statistics);
        }
    }
    private void removeFirstElement(){
        ArrayList<LanguageStatistics> temp = new ArrayList<>();
        for (int i=1;i<this.countLanguageList.size();i++){
            temp.add(this.countLanguageList.get(i));
        }
        this.countLanguageList = temp;
    }

    public ArrayList<LanguageStatistics> getCountArrayList() {
        return countLanguageList;
    }

    public void setCountArrayList(ArrayList<LanguageStatistics> countLanguageList) {
        this.countLanguageList = countLanguageList;
    }

    @Override
    public String toString() {
        return "ConteinerLanguageCount{" +
                "countLanguageList=" + countLanguageList +
                '}';
    }
}
