package Utill;

import Entity.CourseEntity;
import Entity.RegistrationEntity;
import Entity.StudentEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtill {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry sReg = new StandardServiceRegistryBuilder().loadProperties("application.properties").build();
        Metadata build = new MetadataSources(sReg).addAnnotatedClass(RegistrationEntity.class).
                addAnnotatedClass(StudentEntity.class).
                addAnnotatedClass(CourseEntity.class).getMetadataBuilder().build();
        return build.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
