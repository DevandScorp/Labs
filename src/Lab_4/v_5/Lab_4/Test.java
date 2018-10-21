package Lab_4;

import java.util.Arrays;

import Lab_4.Quadratic;
public class Test {
    public static void main(String[] args) {
        Quadratic[] quadratics = new Quadratic[6];
        quadratics[0] = new Quadratic(0,2,-4);
        quadratics[1] = new Quadratic(1,3,-4);
        quadratics[2] = new Quadratic(-6,-5,-1);
        quadratics[3] = new Quadratic(1,-4,0);
        quadratics[4] = new Quadratic(1,0,-9);
        quadratics[5] = new Quadratic(1,15,100);
//        Arrays.stream(quadratics).forEach(Quadratic::solve);
        for(Quadratic quadratic:quadratics){
            quadratic.solve();
        }
    }
}
