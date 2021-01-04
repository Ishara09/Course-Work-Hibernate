package BO.Custom;

import BO.SuperBO;
import Entity.CourseEntity;

import java.util.ArrayList;

public interface CourseBO extends SuperBO {
    public boolean add(CourseEntity s)throws Exception;
    public boolean update(CourseEntity s)throws Exception;
    public boolean remove(String s)throws Exception;
    public CourseEntity searchCustomer(String s)throws Exception;
    public ArrayList<CourseEntity> getAllCustomers()throws Exception;
}
