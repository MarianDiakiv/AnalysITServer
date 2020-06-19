package com.example.analysit.ParseData;

public class PopularLang {
    String language;
    double count;

    public PopularLang(String language, double count) {
        this.language = language;
        this.count = count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
