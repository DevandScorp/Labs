package Lab_6.v_5;

import java.util.List;

public class Enrollee {
    private String name;
    private List<Exam> exams;
    private double mark;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "name='" + name + '\'' +
                ", exams=" + exams +
                ", mark=" + mark +
                '}';
    }

    public double getMark() {
        return mark;
    }

    public void setMark() {
        int sum = 0;
        for(var exam : exams){
            sum+=exam.getMark();
        }
        this.mark = (double)sum/exams.size();
    }



    public Enrollee(String name, List<Exam> exams) {
        this.name = name;
        this.exams = exams;
        mark = 0;
    }
}
