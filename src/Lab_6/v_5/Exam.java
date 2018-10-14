package Lab_6.v_5;

public class Exam {
    private Subject subject;
    private String teacher;
    private int mark;

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
                '}';
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

    public Exam(Subject subject, String teacher) {

        this.subject = subject;
        this.teacher = teacher;
        mark = 0;
    }
}
