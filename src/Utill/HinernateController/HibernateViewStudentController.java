package Utill.HinernateController;

import Entity.RegistrationEntity;
import Entity.StudentEntity;
import Utill.HibernateUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateViewStudentController {
    public List<StudentEntity> getStudents() {

        Transaction tr = null;

        try (Session session = HibernateUtill.getSessionFactory().openSession()) {
            tr = session.beginTransaction();
            List<StudentEntity> list = session.createNativeQuery("SELECT * FROM studententity", StudentEntity.class).list();
            tr.commit();
            return list;
        }


    }

    public List<RegistrationEntity> getAll() {
        Transaction tr = null;
        try (Session session = HibernateUtill.getSessionFactory().openSession()) {
            tr = session.beginTransaction();

            List<RegistrationEntity> list  = session.createNativeQuery("SELECT regNo,registrationentity.date,regFee,courseentity.code,studententity.Id FROM registrationentity INNER JOIN studententity ON registrationentity.sId=studententity.id INNER JOIN courseentity ON registrationentity.cId=courseentity.code;").list();
            tr.commit();
            return list;

        }
    }
//    public ArrayList<S
//    tudentDTO> getStudents() {
//
//        Transaction tr = null;
//
//        try (Session session = HibernateUtill.getSessionFactory().openSession()) {
//            tr = session.beginTransaction();
//
//            List<StudentEntity> list = session.createNativeQuery("SELECT * FROM studententity", StudentEntity.class).list();
//
//            ArrayList<StudentDTO> objects = new ArrayList<>();
//
//            for (StudentEntity sty : list) {
//                StudentDTO sto = new StudentDTO(
//                        sty.getId(),
//                        sty.getName(),
//                        sty.getDob(),
//                        sty.getAddress(),
//                        sty.getContact(),
//                        sty.getGender()
//                );
//                objects.add(sto);
//            }
//
//            tr.commit();
//            return objects;
//        }
//    }
//
//    public List<StudentEntity> getAllID() {
//        Transaction tr = null;
//        List<StudentEntity> list = null;
//
//        try (Session session = HibernateUtill.getSessionFactory().openSession()) {
//            tr = session.beginTransaction();
//
//             list = session.createNativeQuery("select Id from studententity ").list();
//
//            tr.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//       return list;
//    }
}
