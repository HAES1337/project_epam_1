package com.company.dao;

import com.company.domain.Applicants;
import com.company.domain.Faculties;

import java.util.List;

public interface ApplicantsDao<T> extends IDao {
    @Override
    List<T> getAll();

    @Override
    boolean delete(int id);

    boolean create(Applicants obj);

    @Override
    T getName(int id);

    @Override
    boolean changeName(String name, int id);
}
