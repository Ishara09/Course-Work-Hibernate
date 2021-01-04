package DAO;

import DAO.Custom.Impl.CourseDAOImpl;
import DAO.Custom.Impl.RegisterDAOImpl;

public class DAOFactory {
    private static DAOFactory dAOFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }

        return dAOFactory;
    }

    public enum DAOTypes {
       STUDENT , REGISTER , COURSE;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case COURSE:
               return new CourseDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            default:
                return null;
        }

    }
}
