package com.example.analysit.ParseData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parsers {
    public ArrayList<Vacancy> parseDou(String language,String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 50000);
        Elements elements = page.getElementsByClass("l-vacancy");
        ArrayList<Vacancy> vacancyArrayList = new ArrayList<>();
        for (Element e:elements){
            Vacancy vacancy = new Vacancy();
            vacancy.setPosition(e.getElementsByClass("vt").text());
            vacancy.setSity(e.getElementsByClass("cities").text());
            vacancy.setCompany(e.getElementsByClass("company").text());
            vacancy.setInfo(e.getElementsByClass("sh-info").text());
            Elements elAs = e.getElementsByClass("vt");
            List<String> elhref = elAs.eachAttr("href");

            vacancy.setUrlSourse(elhref.get(0));

            vacancy.setVacancyDetails(parseDouDetail(elhref.get(0)));
            System.out.println( "company" +  vacancy.getCompany());
            System.out.println(vacancy.toString());
            System.out.println(language);
            System.out.println("__________________________________________________________________________");
            vacancy.setLanguage(language);
            System.out.println("__________________________________________________________________________");
            System.out.println(vacancy.getLanguage());
            vacancy.setSite("dou");
            vacancyArrayList.add(vacancy);
            vacancy = new Vacancy();
        }
// додати return
        return vacancyArrayList;
    }
    public VacancyDetails parseDouDetail(String url) throws IOException{
        Document page = Jsoup.parse(new URL(url),50000);
        VacancyDetails vacancyDetails = new VacancyDetails();
        Elements elementsDate = page.getElementsByClass("date");
        vacancyDetails.setDate(elementsDate.text());
        System.out.println(vacancyDetails.getDate());
        Elements elnames = page.getElementsByClass("g-h3");
//        System.out.println(elnames.get(0).text());
        Elements elDetails = page.getElementsByClass("text b-typo vacancy-section");
//        System.out.println(elDetails.get(0).html());//не берем текст оскільки отримаєм все одним рядком а нам цього не треба
//        Element element = elDetails.get(0);
        for (int i=0;i<elnames.size()-1;i++){
            vacancyDetails.addDetails(elnames.get(i).text());
            Elements elementsP = elDetails.get(i).getElementsByTag("p");
            System.out.println(elementsP.size());
//            String strForSplit = ""+ elementsP.get(0);
            System.out.println(elDetails.get(i));
            System.out.println("?????????????????????????????????????????????????????////");
//            System.out.println(strForSplit);
            vacancyDetails.addDetails(elDetails.get(i).text());//не берем текст оскільки отримаєм все одним рядком а нам цього не треба
        }
        return vacancyDetails;


    }




    public ArrayList<Vacancy> parseDjinni(String language,String url) throws IOException{
        Document page = Jsoup.parse(new URL(url),500000);
//        Document page = Jsoup.parse(new URL("https://djinni.co/jobs/?location=%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2&primary_keyword=.NET"),500000);
        Elements elements = page.getElementsByClass("list-jobs__item");
        ArrayList<Vacancy> vacancyArrayList = new ArrayList<>();
        for(Element e:elements){
            Vacancy vacancy = new Vacancy();
            vacancy.setPosition(e.getElementsByClass("profile").get(0).text());
            System.out.println(vacancy.getPosition());
            vacancy.setInfo(e.getElementsByClass("list-jobs__description").get(0).text());
            System.out.println(vacancy.getInfo());
            vacancy.setSity("Lviv");
//            vacancy.setCompany(e.getElementsByTag("a").get(0).text());
            vacancy.setCompany(e.getElementsByClass("list-jobs__details").get(0).text());
            System.out.println(vacancy.getCompany());
            String details = "https://djinni.co" + e.getElementsByClass("profile").attr("href");
            System.out.println(details);
            vacancy.setUrlSourse(details);
            vacancy.setVacancyDetails(getDjinniDetails(details));
            vacancy.setLanguage(language);
            vacancy.setSite("gjinni");
            vacancyArrayList.add(vacancy);
            vacancy = new Vacancy();

        }

        return vacancyArrayList;
    }
    public  VacancyDetails getDjinniDetails(String url) throws IOException{
        Document page = Jsoup.parse(new URL(url),500000);
        VacancyDetails details = new VacancyDetails();
        try {
            details.setDate(page.getElementsByClass("text-muted").get(0).text());
            System.out.println("_________________________ " + details.getDate());
//            details.addDetails(page.getElementsByClass("profile-page-section").get(1).text());
            String testProfilrSection = ""+ page.getElementsByClass("profile-page-section").get(1);
            System.out.println("_____________________________________________________");
            System.out.println(testProfilrSection);
            ArrayList<String> stringArrayList  = this.splitDjini(testProfilrSection);
//            for (String s:stringArrayList){
//                System.out.println(s);
//                }
            details.addDetails(stringArrayList);
            details.addDetails(page.getElementsByClass("profile-page-section").get(2).text());
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return details;
        }

//        System.out.println(page.getElementsByClass("profile-page-section").get(1).html());
//        System.out.println(page.getElementsByClass("profile-page-section").get(2).html());


        return details;
    }

public ArrayList<String> splitDjini(String string){
    String[] strArray  = string.split("<br>");
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    ArrayList<String> newStringlist = new ArrayList<>();
    for (int i=0;i<strArray.length;i++){
//        System.out.println(strArray[i]);
        if(strArray[i].contains("</b>")){
            String[] temp = strArray[i].split("</b>");
            for (int j=0;j<temp.length;j++){
                newStringlist.add(temp[i]);
            }

        }else {
            newStringlist.add(strArray[i]);
        }

    }
    // видалення дишніх тегів
    ArrayList<String> listDetails= new ArrayList<>();
    for (String s :newStringlist){
//        String deletestr = "<div class="+'"'+"profile-page-section"+'"'+">";
        String deletestr = "<div class=\"profile-page-section\">";

        if (s.contains(deletestr)){
           s= s.replace(deletestr,"");
            listDetails.add(s);
        }else if(s.contains("</div>")){
           s= s.replace("</div>","");
            listDetails.add(s);
        }else {
            listDetails.add(s);
        }

    }

    return listDetails;
}

}
