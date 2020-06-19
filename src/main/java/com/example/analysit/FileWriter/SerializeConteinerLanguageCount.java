package com.example.analysit.FileWriter;

import com.example.analysit.JsonModel.LanguageStatistics.ConteinerLanguageCount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeConteinerLanguageCount  {
    public void writeData(ConteinerLanguageCount conteinerLanguageCount){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("StatisticsFile.dmm"));
            objectOutputStream.writeObject(conteinerLanguageCount);
            objectOutputStream.close();
        }catch (Exception e ){
            System.out.println(" SerializeConteinerLanguageCount writeData");
            e.printStackTrace();
        }
        }
        public ConteinerLanguageCount readDataFromFile(){
        ConteinerLanguageCount conteinerLanguageCount = new ConteinerLanguageCount();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("StatisticsFile.dmm"));
            conteinerLanguageCount = (ConteinerLanguageCount) objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e ){
            System.out.println("SerializeConteinerLanguageCount readDataFromFile");
        }
        return conteinerLanguageCount;

        }
}
