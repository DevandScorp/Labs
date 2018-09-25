package Lab_4;

import static java.lang.Double.NaN;

public class Quadratic {
    private double a;
    private double b;
    private double c;

    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve(){
        if(a==0){
            System.out.println("x = " + (-c/b));
        }
        else{
            double d = b*b-4*a*c;
            AssertionError:assert d>=0 : "Discriminant < 0";
            if(Double.isNaN((-b+Math.sqrt(d))/(2*a))  || Double.isNaN((-b-Math.sqrt(d))/(2*a))){
                System.out.println("No real solution");
            }
            else{
                System.out.println("x1 = "+((-b+Math.sqrt(d))/(2*a)));
                System.out.println("x2 = "+((-b-Math.sqrt(d))/(2*a)));
            }
        }


    }
}
