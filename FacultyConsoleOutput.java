package com.company.console;

import com.company.service.FacultyService;
import com.company.domain.Faculties;

public class FacultyConsoleOutput {
    FacultyService facultyService=new FacultyService();
    public void outputFaculty(int id){
        System.out.println(facultyService.get(id));
    }
    public void outputAllFaculty(){
        for (Faculties c:facultyService.getAll())
            System.out.println(c);
    }

}
