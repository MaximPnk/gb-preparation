package lesson5.dao;

import lesson5.config.HibernateConfig;
import lesson5.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class StudentDAO {

    SessionFactory factory = HibernateConfig.sessionFactory();

    public void saveOrUpdate(Student student) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }

    public List<Student> findAll() {
        List<Student> students = null;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            students = session.createQuery("from Student", Student.class).getResultList();
            session.getTransaction().commit();
        }
        return students;
    }

    public Optional<Student> findById(Long id) {
        Student student = null;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Query<Student> query = session.createQuery("from Student s where s.id = :id", Student.class);
            query.setParameter("id", id);
            student = query.getSingleResult();
            session.getTransaction().commit();
        } catch (NoResultException ignored) {}
        return Optional.ofNullable(student);
    }

    public void delete(Student student) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }

}
