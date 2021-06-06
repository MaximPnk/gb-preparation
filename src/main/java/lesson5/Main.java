package lesson5;

import lesson5.dao.StudentDAO;
import lesson5.entity.Student;

public class Main {

    static StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        System.out.println(dao.findAll());

        for (int i = 0; i < 1000; i++) {
            dao.saveOrUpdate(new Student("Student #" + i + 1, Math.random()*5));
        }

        System.out.println(dao.findAll());

        dao.saveOrUpdate(new Student(1000L, "UPDATE", 0.0));

        Student student = dao.findById(1000L).orElseThrow(() -> new IllegalArgumentException("There is no such student"));
        System.out.println(student);

        dao.delete(student);

        try {
            Student student1 = dao.findById(1000L).orElseThrow(() -> new IllegalArgumentException("There is no such student"));
        } catch (IllegalArgumentException e) {
            System.out.println("student deleted");
        }
    }

}
