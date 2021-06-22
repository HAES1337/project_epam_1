package com.company.console;

import com.company.service.ApplicantService;
import com.company.domain.Applicants;

public class ApplicantConsoleOutput {
    ApplicantService applicantService = new ApplicantService();
    public void outputApplicant(int id){
        System.out.println(applicantService.get(id));
    }
    public void outputAllApplicant(){
        for (Applicants c:applicantService.getAll())
            System.out.println(c);
    }
}
