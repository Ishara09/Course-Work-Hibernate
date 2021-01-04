package BO.Custom.Impl;

import BO.Custom.CourseBO;
import DAO.Custom.CourseDAO;
import DAO.DAOFactory;
import Entity.CourseEntity;

import java.util.ArrayList;

public class CourseBOImpl implements CourseBO {
    CourseDAO dao = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public boolean add(CourseEntity s) throws Exception {
        return dao.add(s);
    }

    @Override
    public boolean update(CourseEntity s) throws Exception {
        return false;
    }

    @Override
    public boolean remove(String s) throws Exception {
        return false;
    }

    @Override
    public CourseEntity searchCustomer(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<CourseEntity> getAllCustomers() throws Exception {
        return null;
    }
}
