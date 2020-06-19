package com.example.analysit.FileWriter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class FileEmailWriter {
    public FileEmailWriter() throws IOException {
//        existedFile(file);
    }
   private File file = new File("./emailsend.json");
   private ObjectMapper objectMapper = new ObjectMapper();// jackson
   private Map<String, ArrayList<String>> map = objectMapper.readValue(file, new TypeReference<Map<String, ArrayList<String>>>() {
   });

   public void writeToFile(String email,ArrayList<String> list){
       ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
       try{
           existedFile(file);
            map.put(email,list);
            String json = new ObjectMapper().writeValueAsString(map);
            writer.writeValue(file,map);

       }catch (Exception e){
           System.out.println("Exeption in FileEmailWriter class");
           System.out.println(e.getMessage());
       }
   }

   public void rewriteFile(Map<String, ArrayList<String>> map1){
       ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
       try{
           writer.writeValue(file,map1);
       }catch (IOException e ){
           System.out.println(e.getMessage());
       }
   }

    //if file is not exist -
    private File existedFile(File f){

        if(!f.exists()) {
            try {
                f.createNewFile();
                f.getParentFile().mkdirs();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(file.length() == 0)
            try {
                new FileWriter(f).write("{ }");
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("CREATED File Email");

        return f;
    }

    ///

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Map<String, ArrayList<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, ArrayList<String>> map) {
        this.map = map;
    }
}
