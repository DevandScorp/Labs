package Lab_6.v_5;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Enrollee implements Serializable {
    private String name;
    private List<Exam> exams;
    private double mark;
    private Locale locale;
    private Date date;
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
                '}'+ "\nWas created: " + DateLocaleFormat.getTimeStyle(date,locale);
    }

    public double getMark() {
        return mark;
    }

    public Enrollee(String name,Locale locale) {
        this.name = name;
        this.locale = locale;
        this.date = new Date();
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
        this.date = new Date();
        mark = 0;
    }
}
