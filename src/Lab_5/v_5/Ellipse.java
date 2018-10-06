package Lab_5.v_5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;

public class Ellipse implements Function,Comparable<Ellipse>, Iterator<Object>,Iterable<Object> {
    private double a=0;
    private double b=0;
    private double solution_1 = 0;
    private double solution_2 = 0;
    private int iterator_idx = 0;
    private void reset(){
        iterator_idx=0;
    }
    @Override
    public boolean hasNext() {
        return iterator_idx<=3;
    }

    @Override
    public Object next() {
        switch(iterator_idx){
            case 0:
                iterator_idx++;
                return Double.valueOf(a);
            case 1:
                iterator_idx++;
                return Double.valueOf(b);
            case 2:
                iterator_idx++;
                return Double.valueOf(solution_1);
            case 3:
                iterator_idx++;
                return Double.valueOf(solution_2);
            default:
                reset();
                return null;
        }
    }
    public double getA() {
        return a;
    }
    @Override
    public Iterator<Object> iterator() {
        return this;
    }
    public double getB() {
        return b;
    }
    public double getSolution_1() {
        return solution_1;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return Double.compare(ellipse.a, a) == 0 &&
                Double.compare(ellipse.b, b) == 0 &&
                Double.compare(ellipse.solution_1, solution_1) == 0;
    }
    @Override
    public int hashCode() {

        return Objects.hash(a, b, solution_1);
    }
    public Ellipse(String equation){

        Matcher matcher = pattern.matcher(equation);
        if(matcher.find()){
            a = Double.parseDouble(matcher.group(1));
            if(a==0){
                System.out.println("Wrong parameter of a");
            }
        }
        else{
            System.out.println("Wrong parameter of a");
        }
        if(matcher.find()){
            b = Double.parseDouble(matcher.group(1));
            if(b==0){
                System.out.println("Wrong parameter of b");
            }
        }
        else{

            System.out.println("Wrong parameter of b");
        }
    }
    @Override
    public void solve(int x) throws Exception {
        if(x>a)throw new Exception("Wrong x value");
        solution_1 = Math.sqrt(b*(1-Math.pow(x,2)/a));
        solution_2 = -Math.sqrt(b*(1-Math.pow(x,2)/a));
    }
    @Override
    public int compareTo(Ellipse o) {
        return 0;
    }
    @Override
    public String toString() {
        return "Ellipse{ x^2/" + a +
                " + y^2/" + b + " = 1 " +
                ", solution_1=" + solution_1 +
                ", solution_2=" + solution_2 +
                '}';
    }
}
