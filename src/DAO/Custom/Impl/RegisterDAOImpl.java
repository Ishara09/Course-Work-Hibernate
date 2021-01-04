package DAO.Custom.Impl;

import DAO.Custom.RegisterDAO;
import Entity.RegistrationEntity;
import Utill.HinernateController.HibernateAddStudentController;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDAOImpl implements RegisterDAO {


    @Override
    public boolean add(RegistrationEntity enty) throws ClassNotFoundException, SQLException {
        return new HibernateAddStudentController().saveStudent(enty);
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(RegistrationEntity enty) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RegistrationEntity search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RegistrationEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
