package Lab_6.v_5;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void writeData(String[] args) {

    }
    public static void main(String[] args) {
//        Locale[] locales = {
//                new Locale("be","BY"),
//                new Locale("ru","RU"),
//                new Locale("en","US")
//        };
//        Exam[] exams = {
//                new Exam(Subject.MATH,"Naumovich",locales[0]),
//                new Exam(Subject.PROGRAMMING,"Rubashko",locales[0]),
//                new Exam(Subject.ENGLISH,"Shevaldysheva",locales[0])};
//        Connector.writeExams("src\\Lab_6\\v_5\\exams.dat",exams);
//        Teacher[] teachers = {
//                new Teacher("Naumovich",Subject.MATH,locales[0]),
//                new Teacher("Rubashko",Subject.PROGRAMMING,locales[0]),
//                new Teacher("Shevaldysheva",Subject.ENGLISH,locales[0])
//        };
//        Connector.writeTeachers("src\\Lab_6\\v_5\\teachers.dat",teachers);
//        Enrollee[] enrollees = {
//                new Enrollee("Artem",locales[0]),
//                new Enrollee("Max",locales[0]),
//                new Enrollee("Anya",locales[0])
//        };
//        Connector.writeEnrollee("src\\Lab_6\\v_5\\enrolees.dat",enrollees);
        System.out.println("Initial Data");
        Exam[] exams = Connector.readExams("src\\Lab_6\\v_5\\exams.dat");
        Arrays.stream(exams).forEach(System.out::println);
        Teacher[] teachers = Connector.readTeachers("src\\Lab_6\\v_5\\teachers.dat");
        Arrays.stream(teachers).forEach(System.out::println);
        Enrollee[] enrollees = Connector.readEnrollee("src\\Lab_6\\v_5\\enrolees.dat");
        Arrays.stream(enrollees).forEach(System.out::println);
        System.out.println("____________________________________________");
        Arrays.stream(teachers).forEach(t -> {
            t.setExamMark(exams);
        });
        enrollees[0].setExams(Arrays.stream(exams).collect(Collectors.toList()));
        Exam[] exams_1 = Connector.readExams("src\\Lab_6\\v_5\\exams.dat");
        Arrays.stream(teachers).forEach(t -> {
            t.setExamMark(exams_1);
        });
        enrollees[1].setExams(Arrays.stream(exams_1).collect(Collectors.toList()));

        Exam[] exams_2 = Connector.readExams("src\\Lab_6\\v_5\\exams.dat");
        Arrays.stream(teachers).forEach(t -> {
            t.setExamMark(exams_2);
        });
        enrollees[2].setExams(Arrays.stream(exams_2).collect(Collectors.toList()));
        Arrays.stream(enrollees).forEach(Enrollee::setMark);
        Arrays.stream(enrollees).forEach(System.out::println);
        System.out.println("__________________________________________________");
        Comparator<Enrollee> enrolleeComparator = (Enrollee a,Enrollee b) -> {
            if(a.getMark()<b.getMark())return 1;
            if(a.getMark()>b.getMark())return -1;
            return 0;
        };
        Arrays.sort(enrollees,enrolleeComparator);
        Faculty faculty = new Faculty(Arrays.stream(enrollees).collect(Collectors.toList()),2);
        faculty.setStudents();
        faculty.getEnrollees().forEach(System.out::println);

    }
}
