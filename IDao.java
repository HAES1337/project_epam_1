package com.company.dao;

import java.util.List;

public interface IDao<T> {
    List<T> getAll();


    boolean delete(int id);

    T getName(int id);

    boolean changeName(String name, int id);

}