package hibernate;

import demo.Course;
import demo.Instructor;
import demo.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatingInstructorAndInstructorDetail {

    public static void main(String[] args) {
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

//            Instructor instructor = new Instructor("Mabasttttt", "Hashm", "m@yahoo.com");
//            System.out.println("Created Instructor : " + instructor);
//            InstructorDetail instructorDetail = new InstructorDetail("Youtube.com", "Hiking");
//            System.out.println("Created InstructorDetail : " + instructorDetail);
//            instructor.setInstructorDetail(instructorDetail);
//            System.out.println("Instructor Detail added for instructor");


            session.beginTransaction();
            int id = 2;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("RETRIEVED : " + instructor.getFirstName());

            Course c1 = new Course("Exhaust Biology");
//            Course c2 = new Course("Biology Biology");
//            Course c3 = new Course("Love Biology");
            System.out.println("Adding : ");
            instructor.addCourses(c1);
//            instructor.addCourses(c2);
//            instructor.addCourses(c3);
            System.out.println("Added ! COURSES : " + instructor.getCourses());

            session.save(c1);
//            session.save(c2);
//            session.save(c3);

            session.getTransaction().commit();
            System.out.println("DONE ! ");
        } catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            factory.close();
            session.close();
        }

        factory.close();
        session.close();

    }

}
