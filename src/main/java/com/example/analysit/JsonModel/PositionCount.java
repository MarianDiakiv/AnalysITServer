package com.example.analysit.JsonModel;

public class PositionCount {
    private String position;
    private Integer count;

    public PositionCount() {
    }

    public PositionCount(String position, Integer count) {
        this.position = position;
        this.count = count;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PositionCount{" +
                "position='" + position + '\'' +
                ", count=" + count +
                '}';
    }
}
