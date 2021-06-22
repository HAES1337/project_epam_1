package com.company.dao;

import com.company.domain.Faculties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.company.connection.MyConnection;


public class FacultiesDaoImpl<T> implements FacultiesDao  {
    Connection connection;

    public FacultiesDaoImpl() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.connection;
    }

    private static final String SELECT_ALL = "SELECT * FROM faculties;";
    private static final String SELECT_FACULTY = "SELECT * FROM faculties WHERE faculties.id_faculty=?;";
    private static final String UPDATE_FACULTY_NAME = "UPDATE faculties SET name_faculty=? " +
            "WHERE id_faculty=?";
    private static final String DELETE_FACULTY = "DELETE FROM faculties WHERE faculties.id_faculty=?;";
    private static final String CREATE_FACULTY = "INSERT INTO faculties (name_faculty) VALUES(?)";
    private static final String LOOK_FOR_FACULTY = "SELECT * FROM faculties WHERE faculties.id_faculty=?;";


    @Override
    public List<Faculties> getAll() {
        List list = new ArrayList();
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Faculties faculties = new Faculties();
                faculties.setFacultyName(rs.getString("name_faculty"));
                list.add(faculties);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(LOOK_FOR_FACULTY, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            if (!resultSet.first()) {
                return false;
            } else {
                statement = connection.prepareStatement(DELETE_FACULTY);
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean create(Faculties faculties) {
        try {
            PreparedStatement statement = null;
            String getfacultyName = faculties.getfacultyName();
            statement = connection.prepareStatement(CREATE_FACULTY);
            statement.setString(1, getfacultyName);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }


    @Override
    public Faculties getName(int id) {
        Faculties faculties = new Faculties();

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_FACULTY);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            faculties.setFacultyName(rs.getString("name_faculty"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return faculties;

    }

    @Override
    public boolean changeName(String name, int id) {
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_FACULTY_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
