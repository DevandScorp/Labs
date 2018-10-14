package Lab_6.v_5;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Teacher implements Serializable {
    private String name;
    private Subject subject;
    private Random random;
    private Locale locale;
    private Date date;
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject=" + subject +
                '}'+ "\nWas created: " + DateLocaleFormat.getTimeStyle(date,locale);
    }


    public Teacher(String name, Subject subject,Locale locale) {
        this.locale = locale;
        this.name = name;
        this.subject = subject;
        this.date = new Date();
        random = new Random();
    }

    public void setExamMark(Exam[] exams){
        for(var exam:exams){
            if(exam.getSubject()==this.subject){
                exam.setMark(random.nextInt(10));
            }
        }
    }
}
