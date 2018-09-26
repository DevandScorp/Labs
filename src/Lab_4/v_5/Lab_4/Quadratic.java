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
        if(a == 0){
            System.out.printf("x = %.1f\n",(-c/b));
        }
        else{
            double discriminant = b * b - 4 * a * c;
            AssertionError:assert discriminant >= 0 : "Discriminant < 0";
            if(Double.isNaN((-b+Math.sqrt(discriminant))/(2*a))  || Double.isNaN((-b-Math.sqrt(discriminant))/(2*a))){
                System.out.println("No real solution");
            }
            else{
                System.out.printf("x1 = %.1f\n",((-b+Math.sqrt(discriminant))/(2*a)));
                System.out.printf("x2 = %.1f\n",((-b-Math.sqrt(discriminant))/(2*a)));
            }
        }


    }
}