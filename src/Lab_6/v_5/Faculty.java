package Lab_6.v_5;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private List<Enrollee> enrollees;
    private int studentsCount;

    public Faculty(List<Enrollee> enrollees, int studentsCount) {
        this.enrollees = enrollees;
        this.studentsCount = studentsCount;
    }
    public void setStudents(){
        int count = 0;
        List<Enrollee> enrollees1 = new ArrayList<>();
        for(Enrollee enrollee:enrollees){
            if(count<studentsCount){
                enrollees1.add(enrollee);
            }
            else{
                break;
            }
            count++;
        }
        enrollees.clear();
        enrollees.addAll(enrollees1);


    }
    public List<Enrollee> getEnrollees() {
        return enrollees;
    }

    public void setEnrollees(List<Enrollee> enrollees) {
        this.enrollees = enrollees;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }
}
