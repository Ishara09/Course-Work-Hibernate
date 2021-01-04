package DAO.Custom.Impl;

import DAO.Custom.CourseDAO;
import Entity.CourseEntity;
import Utill.HinernateController.HibernateCourseController;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean add(CourseEntity enty) throws ClassNotFoundException, SQLException {
        return new HibernateCourseController().addCourse(enty);
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(CourseEntity enty) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CourseEntity search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CourseEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
