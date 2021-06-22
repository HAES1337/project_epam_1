package com.company.service;

import com.company.dao.FacultiesDao;
import com.company.dao.FacultiesDaoImpl;
import com.company.dao.IDao;
import com.company.domain.Faculties;

import java.util.List;

public class FacultyService {
    IDao newDao = new FacultiesDaoImpl();
    FacultiesDao facultiesDao = new FacultiesDaoImpl();

    public Faculties get(int id) {
        return (Faculties) newDao.getName(id);

    }

    public List<Faculties> getAll() {
        return newDao.getAll();
    }

    public boolean createFaculty(Faculties faculties) {
        facultiesDao.create(faculties);
        return true;
    }

    public boolean deleteFacultyName(int id){
        newDao.delete(id);
        return true;
    }

    public boolean changeFacultyName(String name,int id){
        newDao.changeName(name,id);
        return true;
    }


}
