package com.company.dao;

import com.company.connection.MyConnection;
import com.company.domain.Applicants;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicantsDaoImpl<T> implements ApplicantsDao {
    Connection connection;

    public ApplicantsDaoImpl() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.connection;
    }

    private static final String SELECT_ALL = "SELECT * FROM applicants;";
    private static final String SELECT_APPLICANT = "SELECT * FROM applicants WHERE applicants.id_applicants=?;";
    private static final String UPDATE_APPLICANT_NAME = "UPDATE applicants SET name_applicants=? " +
            "WHERE id_applicants=?";
    private static final String DELETE_APPLICANTS = "DELETE FROM applicants WHERE applicants.id_applicants=?;";
    private static final String CREATE_APPLICANTS = "INSERT INTO applicants (name_applicants) VALUES(?)";
    private static final String LOOK_FOR_APPLICANTS = "SELECT * FROM applicants WHERE applicants.id_applicants=?;";



    @Override
    public List getAll() {
        List list = new ArrayList();
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Applicants applicants = new Applicants();
                applicants.setApplicantName(rs.getString("name_applicants"));
                list.add(applicants);
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
            statement = connection.prepareStatement(LOOK_FOR_APPLICANTS, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            if (!resultSet.first()) {
                return false;
            } else {
                statement = connection.prepareStatement(DELETE_APPLICANTS);
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean create(Applicants applicants) {
        try {
            PreparedStatement statement = null;
            String getApplicantName = applicants.getApplicantName ();
            statement = connection.prepareStatement(CREATE_APPLICANTS);
            statement.setString(1, getApplicantName);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public Applicants getName(int id) {
        Applicants applicants = new Applicants();

        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SELECT_APPLICANT);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            applicants.setApplicantName(rs.getString("name_applicants"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return applicants;
    }

    @Override
    public boolean changeName(String name, int id) {
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(UPDATE_APPLICANT_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
