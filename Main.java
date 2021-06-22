package com.company;

import com.company.console.ApplicantConsoleOutput;
import com.company.console.FacultyConsoleOutput;
import com.company.domain.Applicants;
import com.company.service.ApplicantService;
import com.company.service.FacultyService;
import com.company.domain.Faculties;



public class Main {

    public static void main(String[] args) {

        ApplicantConsoleOutput applicantConsoleOutput = new ApplicantConsoleOutput();
        FacultyConsoleOutput facultyConsoleOutput = new FacultyConsoleOutput();
        ApplicantService applicantService = new ApplicantService();
        FacultyService facultyService = new FacultyService();
        facultyService.createFaculty(new Faculties("mathematics"));
        facultyService.createFaculty(new Faculties("history"));
        facultyService.createFaculty(new Faculties("jurisprudence"));
        applicantService.createApplicant(new Applicants("ALEXANDER"+""+"KARDANOV"));
        applicantService.createApplicant(new Applicants("DMITRIY"+""+"GUBERNIEV"));
        applicantConsoleOutput.outputAllApplicant();
        facultyConsoleOutput.outputAllFaculty();
    }
}
