package com.example.analysit.JsonModel.LanguageStatistics;

import java.io.Serializable;

public class LanguageCount implements Comparable<LanguageCount>, Serializable {
    private String language;
    private Integer count;

    public LanguageCount(String language, int count) {
        this.language = language;
        this.count = count;
    }

    public LanguageCount() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(LanguageCount o) {
        return this.count.compareTo(o.getCount());
    }

    @Override
    public String toString() {
        return "LanguageCount{" +
                "language='" + language + '\'' +
                ", count=" + count +
                '}';
    }
}
