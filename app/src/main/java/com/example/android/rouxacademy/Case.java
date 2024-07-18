package com.example.android.rouxacademy;

public class Case {

    private int CaseNumber;
    private int Case_pic_des;

    private String Casetitle;
    private String description;
   

    public Case(int CaseNumber, String Casetitle, String description,int Case_pic_des) {
        this.CaseNumber = CaseNumber;
        this.Casetitle = Casetitle;
        this.description = description;
        this.Case_pic_des=Case_pic_des;
        
    }

    public int getCase_pic_des() {
        return Case_pic_des;
    }
    public int getCaseNumber() {
        return CaseNumber;
    }

    public String getCaseTitle() {
        return Casetitle;
    }

    public String getDescription() {
        return description;
    }

   

    @Override
    public String toString() {
        return Casetitle;
    }
}
