package com.company.domain;

public class Applicants {
    String applicantName;
    int applicantID;


    public Applicants (){

    }

    public Applicants (String applicantName){
        this.applicantName = applicantName;
    }

    public String getApplicantName () {return applicantName;}
    public void setApplicantName (String applicantName) {this.applicantName = applicantName;}
    public String toString () {return applicantID+" "+applicantName;}
}
