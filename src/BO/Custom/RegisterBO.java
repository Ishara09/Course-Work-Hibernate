package BO.Custom;

import BO.SuperBO;
import Entity.RegistrationEntity;

import java.util.ArrayList;

public interface RegisterBO extends SuperBO {
    public boolean add(RegistrationEntity s)throws Exception;
    public boolean update(RegistrationEntity s)throws Exception;
    public boolean remove(String s)throws Exception;
    public RegistrationEntity searchCustomer(String s)throws Exception;
    public ArrayList<RegistrationEntity> getAllCustomers()throws Exception;
}
