package com.example.analysit.ParseData;

import java.io.Serializable;
import java.util.Objects;

public class Vacancy implements Serializable {
  private   int id;
    private  String site;
    private  String company;
    private String position;
    private  String  sity;
    private String urlSourse;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id &&
                Objects.equals(site, vacancy.site) &&
                Objects.equals(company, vacancy.company) &&
                Objects.equals(position, vacancy.position) &&
                Objects.equals(sity, vacancy.sity) &&
                Objects.equals(urlSourse, vacancy.urlSourse) &&
                Objects.equals(info, vacancy.info) &&
                Objects.equals(language, vacancy.language) &&
                Objects.equals(vacancyDetails, vacancy.vacancyDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, site, company, position, sity, urlSourse, info, language, vacancyDetails);
    }

    //private    String shortInfo;
private String info;
    private String language;
    private VacancyDetails vacancyDetails;

//    public Vacancy(int id, String site, String company, String position, String sity, String shortInfo, String info, String language, VacancyDetails vacancyDetails) {
//        this.id = id;
//        this.site = site;
//        this.company = company;
//        this.position = position;
//        this.sity = sity;
//        this.shortInfo = shortInfo;
//        this.info = info;
//        this.language = language;
//        this.vacancyDetails = vacancyDetails;
//    }


    public Vacancy(int id, String site, String company, String position, String sity, String urlSourse, String info, String language, VacancyDetails vacancyDetails) {
        this.id = id;
        this.site = site;
        this.company = company;
        this.position = position;
        this.sity = sity;
        this.urlSourse = urlSourse;
        this.info = info;
        this.language = language;
        this.vacancyDetails = vacancyDetails;
    }

    public Vacancy() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

//    public String getShortInfo() {
//        return shortInfo;
//    }
//
//    public void setShortInfo(String shortInfo) {
//        this.shortInfo = shortInfo;
//    }

    public VacancyDetails getVacancyDetails() {
        return vacancyDetails;
    }

    public void setVacancyDetails(VacancyDetails vacancyDetails) {
        this.vacancyDetails = vacancyDetails;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUrlSourse() {
        return urlSourse;
    }

    public void setUrlSourse(String urlSourse) {
        this.urlSourse = urlSourse;
    }
//    @Override
//    public String toString() {
//        return "Vacancy{" +
//                "id=" + id +
//                ", site='" + site + '\'' +
//                ", company='" + company + '\'' +
//                ", position='" + position + '\'' +
//                ", sity='" + sity + '\'' +
//                ", shortInfo='" + shortInfo + '\'' +
//                ", info='" + info + '\'' +
//                ", language='" + language + '\'' +
//                ", vacancyDetails=" + vacancyDetails +
//                '}';
//    }

//    @Override
//    public String toString() {
//        return "Vacancy{" +
//                "id=" + id +
//                ", site='" + site + '\'' +
//                ", company='" + company + '\'' +
//                ", position='" + position + '\'' +
//                ", sity='" + sity + '\'' +
//                ", info='" + info + '\'' +
//                ", language='" + language + '\'' +
//                ", vacancyDetails=" + vacancyDetails +
//                '}';
//    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", site='" + site + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", sity='" + sity + '\'' +
                ", urlSourse='" + urlSourse + '\'' +
                ", info='" + info + '\'' +
                ", language='" + language + '\'' +
                ", vacancyDetails=" + vacancyDetails +
                '}';
    }
    public boolean sheckVacancy(Vacancy vacancy){
        if (this.company.equals(vacancy.getCompany()) && this.language.equals(vacancy.getLanguage())
                &&this.position.equals(vacancy.getPosition()) && this.info.equals(vacancy.getInfo())){
            return false;
        }else {
            return true;
        }
    }


}
