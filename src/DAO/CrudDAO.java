package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO {
        public boolean add(T enty) throws ClassNotFoundException, SQLException;
        public boolean delete(ID id) throws ClassNotFoundException, SQLException;
        public boolean update(T enty) throws SQLException, ClassNotFoundException ;
        public T search(ID id) throws SQLException, ClassNotFoundException;
        public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    }

