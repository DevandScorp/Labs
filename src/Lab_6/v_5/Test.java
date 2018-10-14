package Lab_6.v_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Enrollee> enrollees = new ArrayList<>();
        Exam[] exams = {
                new Exam(Subject.MATH,"Naumovich"),
                new Exam(Subject.PROGRAMMING,"Rubashko"),
                new Exam(Subject.ENGLISH,"Shevaldysheva")};
        exams[0].setMark(9);
        exams[1].setMark(9);
        exams[2].setMark(9);
        enrollees.add(new Enrollee("Artem", Arrays.stream(exams).collect(Collectors.toList())));
        Exam[] exams_1 = {
                new Exam(Subject.MATH,"Naumovich"),
                new Exam(Subject.PROGRAMMING,"Rubashko"),
                new Exam(Subject.ENGLISH,"Shevaldysheva")};
        exams_1[0].setMark(9);
        exams_1[1].setMark(8);
        exams_1[2].setMark(9);
        enrollees.add(new Enrollee("Max",Arrays.stream(exams_1).collect(Collectors.toList())));
        Exam[] exams_2 = {
                new Exam(Subject.MATH,"Naumovich"),
                new Exam(Subject.PROGRAMMING,"Rubashko"),
                new Exam(Subject.ENGLISH,"Shevaldysheva")};
        exams_2[0].setMark(9);
        exams_2[1].setMark(8);
        exams_2[2].setMark(8);
        enrollees.add(new Enrollee("Anya",Arrays.stream(exams_2).collect(Collectors.toList())));
        enrollees.forEach(Enrollee::setMark);
        Comparator<Enrollee> enrolleeComparator = (Enrollee a,Enrollee b) -> {
            if(a.getMark()<b.getMark())return 1;
            if(a.getMark()>b.getMark())return -1;
            return 0;
        };
        enrollees.sort(enrolleeComparator);
        Faculty faculty = new Faculty(enrollees,2);
        faculty.setStudents();
        faculty.getEnrollees().forEach(System.out::println);

    }
}
