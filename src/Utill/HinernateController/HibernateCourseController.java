package Utill.HinernateController;

import Entity.CourseEntity;
import Utill.HibernateUtill;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateCourseController {


    public boolean addCourse(CourseEntity enty) {
        Transaction tr = null;

        try (Session session = HibernateUtill.getSessionFactory().openSession()) {
            tr = session.beginTransaction();

            session.save(enty);
            tr.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tr.rollback();
        }

        return true;

    }

    public List<String> getIDS() {
        Transaction tr = null;
        List<String> list = null;

        try  {
            Session session = HibernateUtill.getSessionFactory().openSession();
            tr = session.beginTransaction();

            list = session.createNativeQuery("select code from courseentity ").list();

            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<CourseEntity> getCourse() {
        Transaction tr = null;

        try (Session session = HibernateUtill.getSessionFactory().openSession()) {
            tr = session.beginTransaction();

            List<CourseEntity> list = session.createNativeQuery("SELECT * FROM courseentity", CourseEntity.class).list();

            tr.commit();
            return list;
        }
    }

    public boolean remove(String code) {
        Transaction tr = null;
        try(Session session = HibernateUtill.getSessionFactory().openSession()) {
            tr = session.beginTransaction();
//            Customer c = session.get(Customer.class, "C001");
            CourseEntity sto = session.get(CourseEntity.class , code);
            session.delete(sto);
            tr.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            tr.rollback();
        }
        return true;
    }
}
