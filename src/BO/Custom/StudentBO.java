package BO.Custom;

import BO.SuperBO;
import DTO.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO s)throws Exception;
    public boolean update(StudentDTO s)throws Exception;
    public boolean remove(String s)throws Exception;
    public StudentDTO searchCustomer(String s)throws Exception;
    public ArrayList<StudentDTO> getAllCustomers()throws Exception;
}
