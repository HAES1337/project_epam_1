package com.company.domain;

public class Faculties {
    String facultyName;
    int facultyID;


public Faculties (){

}

public Faculties (String facultyName){
    this.facultyName = facultyName;
}

public String getfacultyName () {return facultyName;}
public void setFacultyName (String facultyName) {this.facultyName = facultyName;}
public String toString () {return facultyID+" "+facultyName;}

}