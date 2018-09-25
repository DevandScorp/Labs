package Lab_4;

public class Test {
    public static void main(String[] args) {
        Quadratic quadratic = new Quadratic(0,2,-4);
        quadratic.solve();
        quadratic = new Quadratic(1,3,-4);
        quadratic.solve();
        quadratic = new Quadratic(-6,-5,-1);
        quadratic.solve();
        quadratic = new Quadratic(1,-4,0);
        quadratic.solve();
        quadratic = new Quadratic(1,0,-9);
        quadratic.solve();
        quadratic = new Quadratic(1,15,100);
        quadratic.solve();
    }
}
