package BO.Custom.Impl;

import BO.Custom.RegisterBO;
import DAO.Custom.RegisterDAO;
import DAO.DAOFactory;
import Entity.RegistrationEntity;

import java.util.ArrayList;

public class RegistrationBOImpl implements RegisterBO {

    RegisterDAO dao = (RegisterDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTER);


    @Override
    public boolean add(RegistrationEntity s) throws Exception {
        return dao.add(s);
    }

    @Override
    public boolean update(RegistrationEntity s) throws Exception {
        return false;
    }

    @Override
    public boolean remove(String s) throws Exception {
        return false;
    }

    @Override
    public RegistrationEntity searchCustomer(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegistrationEntity> getAllCustomers() throws Exception {
        return null;
    }
}
