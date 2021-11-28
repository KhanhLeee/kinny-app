package com.sinhvien.kinny;

import java.util.ArrayList;

public class HistoryWeight {

    String weight;
    String bmi;
    String date;

    public HistoryWeight(String weight, String bmi, String date) {
        this.weight = weight;
        this.bmi = bmi;
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ArrayList initHW(){
        ArrayList<HistoryWeight> arrayList = new ArrayList<>();
        arrayList.add(new HistoryWeight("55", "20.7", "03/11/2021"));
        arrayList.add(new HistoryWeight("54.3", "20.4", "10/11/2021"));
        return arrayList;
    }
}
