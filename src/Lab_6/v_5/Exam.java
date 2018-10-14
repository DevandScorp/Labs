package Lab_6.v_5;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class Exam implements Serializable {
    private Subject subject;
    private String teacher;
    private int mark;
    private Date date;
    private Locale locale;
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "subject=" + subject +
                ", teacher='" + teacher + '\'' +
                ", mark=" + mark +
                '}'+ "\nWas created: " + DateLocaleFormat.getTimeStyle(date,locale);
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Exam(Subject subject, String teacher,Locale locale) {
        this.locale = locale;
        this.date = new Date();
        this.subject = subject;
        this.teacher = teacher;
        mark = 0;
    }
}
