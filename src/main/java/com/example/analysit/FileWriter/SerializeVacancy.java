package com.example.analysit.FileWriter;

import com.example.analysit.ParseData.VacancyData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeVacancy {
    public void writeData(VacancyData vacancyData){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Vacancy.dmm"));
            objectOutputStream.writeObject(vacancyData);
            objectOutputStream.close();
        }catch (Exception e ){
            System.out.println("SerializeVacancy writeData exeption");
            e.printStackTrace();
        }
        }
        public VacancyData readVacancyData(){
        VacancyData vacancyData = new VacancyData();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Vacancy.dmm"));
             vacancyData = (VacancyData) objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e ){
            System.out.println("SerializeVacancy readVacancyData exeption");
            e.printStackTrace();
        }
        return vacancyData;
        }
}
