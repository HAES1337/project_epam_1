package com.company.service;

import com.company.dao.ApplicantsDaoImpl;
import com.company.dao.ApplicantsDao;
import com.company.dao.IDao;
import com.company.domain.Applicants;


import java.util.List;

public class ApplicantService {
    IDao newDao = new ApplicantsDaoImpl();
    ApplicantsDao applicantsDao = (ApplicantsDao) new ApplicantsDaoImpl();

    public Applicants get(int id) {
        return (Applicants) newDao.getName(id);

    }

    public List<Applicants> getAll() {
        return newDao.getAll();
    }

    public boolean createApplicant(Applicants applicants) {
        applicantsDao.create(applicants);
        return true;
    }

    public boolean deleteApplicant(int id){
        newDao.delete(id);
        return true;
    }

    public boolean changApplicantName(String name,int id){
        newDao.changeName(name,id);
        return true;
    }
}
