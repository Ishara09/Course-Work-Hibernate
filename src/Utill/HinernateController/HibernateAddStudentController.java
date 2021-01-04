package Utill.HinernateController;

import Entity.RegistrationEntity;
import Entity.StudentEntity;
import Utill.HibernateUtill;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateAddStudentController {
    public boolean saveStudent(RegistrationEntity s) {
        Transaction tr = null;

        try(Session session = HibernateUtill.getSessionFactory().openSession()) {
            tr = session.beginTransaction();

            session.save(s);
            tr.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            tr.rollback();
        }
        return true;
    }

    public boolean remove(String id) {
        Transaction tr = null;
        try(Session session = HibernateUtill.getSessionFactory().openSession()) {
            tr = session.beginTransaction();
//            Customer c = session.get(Customer.class, "C001");
            StudentEntity sto = session.get(StudentEntity.class , id);
            session.delete(sto);
            tr.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            tr.rollback();
        }
        return true;
    }

//    public boolean UpdateStudent(StudentEntity s) {
//        Transaction tr = null;
//        try(Session session = HibernateUtill.getSessionFactory().openSession()) {
//            tr = session.beginTransaction();
//
//            StudentEntity sty = session.get(StudentEntity.class , s.getId() );
//
//            sty.setName(s.getName());
//            sty.setAddress(s.getAddress());
//            sty.setContact(s.getContact());
//            sty.setDob(s.getDob());
//            sty.setGender(s.getGender());
//
//            //Dirty Checking
//            tr.commit();
//        }catch (HibernateException e){
//            e.printStackTrace();
//            tr.rollback();
//        }
//        return true;
//    }

//    public boolean deleteStudent(String s) {
//        Transaction tr = null;
//        try(Session session = HibernateUtill.getSessionFactory().openSession()) {
//            tr = session.beginTransaction();
////            Customer c = session.get(Customer.class, "C001");
//            StudentEntity sto = session.get(StudentEntity.class , s);
//            session.delete(sto);
//            tr.commit();
//        }catch (HibernateException e){
//            e.printStackTrace();
//            tr.rollback();
//        }
//        return true;
//    }

//    public List loadCid() {
//
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//
//        List list = session.createNativeQuery("select code from course ").list();
//
//        transaction.commit();
//        session.close();
//        sessionFactory.close();

//        return list;
//
//    }

//    public void saveRegistrations(Registration r) {
//
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//
//        session.save(r);
//
//        transaction.commit();
////        session.close();
////        sessionFactory.close();
//    }

//    public void registretion(Registration r, String course) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Course course1 = session.get(Course.class, course);
//        r.setCourse(course1);
//        session.save(r);
//
//
//        transaction.commit();
//        session.close();
//    }
}
