package Lab_5.v_5;

import Lab_5.v_5.Comparators.SortByA;
import Lab_5.v_5.Comparators.SortByB;
import Lab_5.v_5.Comparators.SortByS;
import Lab_5.v_5.Comparators.SortByS2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        Ellipse[] ellipses = {
                new Ellipse("x^2/7 + y^2/9 = 1"),
                new Ellipse("x^2/6 + y^2/8 = 1"),
                new Ellipse("x^2/8 + y^2/7 = 1"),
                new Ellipse("x^2/9 + y^2/6 = 1"),
        };
        System.out.println("Iterable Ellipse properties");
        for(var a : ellipses[0]){
            System.out.print(a + " ");
        }
        System.out.println();
        Hyperbola[] hyperbolas = {
                new Hyperbola("x^2/7 - y^2/9 = 1"),
                new Hyperbola("x^2/6 - y^2/8 = 1"),
                new Hyperbola("x^2/8 - y^2/7 = 1"),
                new Hyperbola("x^2/9 - y^2/6 = 1"),
        };
        System.out.println("Iterable Hyperbola properties");
        for(var a : hyperbolas[0]){
            System.out.print(a + " ");
        }
        System.out.println();
        Hyperbola[] hyperbolas_A = {
                new Hyperbola("x^2/6 - y^2/8 = 1"),
                new Hyperbola("x^2/7 - y^2/9 = 1"),
                new Hyperbola("x^2/8 - y^2/7 = 1"),
                new Hyperbola("x^2/9 - y^2/6 = 1"),
        };
        Ellipse[] ellipses_A = {
                new Ellipse("x^2/6 + y^2/8 = 1"),
                new Ellipse("x^2/7 + y^2/9 = 1"),
                new Ellipse("x^2/8 + y^2/7 = 1"),
                new Ellipse("x^2/9 + y^2/6 = 1"),
        };
        Arrays.stream(hyperbolas).forEach(o ->{
            try {
                o.solve(3);
            } catch (Exception e) {
                System.out.println(o + " wasn't solved");
            }
        });
        Arrays.stream(hyperbolas_A).forEach(o ->{
            try {
                o.solve(3);
            } catch (Exception e) {
                System.out.println(o + " wasn't solved");
            }
        });
        Arrays.stream(ellipses).forEach(o ->{
            try {
                o.solve(1);
            } catch (Exception e) {
                System.out.println(o + " wasn't solved");
            }
        });
        Arrays.stream(ellipses_A).forEach(o ->{
            try {
                o.solve(1);
            } catch (Exception e) {
                System.out.println(o + " wasn't solved");
            }
        });
        System.out.println("Ellipses(solution for x = 1) : ");
        Arrays.stream(ellipses).forEach(System.out::println);
        System.out.println("__________________________________________________________________________________________________");
        System.out.println("Hyperbolas(solution for x = 3) : ");
        Arrays.stream(hyperbolas).forEach(System.out::println);
        System.out.println("__________________________________________________________________________________________________");
        Arrays.sort(hyperbolas,new SortByA<Hyperbola>());
        System.out.println("Comparing sorted array by a and initialized array,sorted by a(Hyperbola)");
        System.out.println("Result: " + (Arrays.compare(hyperbolas,hyperbolas_A)==0));
        Arrays.sort(ellipses,new SortByA<Ellipse>());
        System.out.println("Comparing sorted array by a and initialized array,sorted by a(Ellipse)");
        System.out.println("Result: " + (Arrays.compare(ellipses,ellipses_A)==0));
        Arrays.sort(hyperbolas,new SortByB<Hyperbola>());
        System.out.println("Comparing sorted array by b and initialized array,sorted by b(Hyperbola)");
        System.out.println("Result: " + (Arrays.compare(hyperbolas,hyperbolas_A)==0));
        Arrays.sort(ellipses,new SortByB<Ellipse>());
        System.out.println("Comparing sorted array by b and initialized array,sorted by b(Ellipse)");
        System.out.println("Result: " + (Arrays.compare(ellipses,ellipses_A)==0));
        Arrays.sort(hyperbolas,new SortByS<Hyperbola>());
        Arrays.sort(hyperbolas_A,new SortByS<Hyperbola>());
        System.out.println("Comparing sorted array by solution_1 and initialized array,sorted by solution_1(Hyperbola)");
        System.out.println("Result: " + (Arrays.compare(hyperbolas,hyperbolas_A)==0));
        Arrays.sort(ellipses,new SortByS<Ellipse>());
        Arrays.sort(ellipses_A,new SortByS<Ellipse>());
        System.out.println("Comparing sorted array by solution_1 and initialized array,sorted by solution_1(Ellipse)");
        System.out.println("Result: " + (Arrays.compare(ellipses,ellipses_A)==0));
        Arrays.sort(hyperbolas,new SortByS2<Hyperbola>());
        Arrays.sort(hyperbolas_A,new SortByS2<Hyperbola>());
        System.out.println("Comparing sorted array by solution_2 and initialized array,sorted by solution_2(Hyperbola)");
        System.out.println("Result: " + (Arrays.compare(hyperbolas,hyperbolas_A)==0));
        Arrays.sort(ellipses,new SortByS2<Ellipse>());
        Arrays.sort(ellipses_A,new SortByS2<Ellipse>());
        System.out.println("Comparing sorted array by solution_2 and initialized array,sorted by solution_2(Ellipse)");
        System.out.println("Result: " + (Arrays.compare(ellipses,ellipses_A)==0));
    }
}
