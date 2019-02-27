package lab3.equations;

import lab3.methods.*;
import lab3.main.Main;

import java.lang.reflect.Method;

public class FirstEquation implements EquationInterface {
    private double[] borders;

    public FirstEquation() {
        borders = new double[2];
        borders[0] = 0;
        borders[1] = 1;
    }

    @Override
    public  double solve(double x) {
        double equation = Math.cos(x) - x;
        return equation;
    }

    @Override
    public double solveDiff(double x) {
        double equation = - Math.sin(x) - 1;
        return equation;
    }

    @Override
    public void bisection() {
        ultimateOut( new Bisection(new FirstEquation()) );
    }

    @Override
    public void hords() {
        ultimateOut( new Hords(new FirstEquation()) );
    }

    @Override
    public void newton() {
        ultimateOut( new Newton(new FirstEquation()) );
    }

    @Override
    public void paraboles() {
        ultimateOut( new Paraboles(new FirstEquation()) );
    }

    private void ultimateOut(MethodInterface method) {

        Main.out.print(String.format("Колличество итераций: %d\n", Methods.roots(method, borders)));
    }

    @Override
    public void printAll() {
        Main.out.print("Первое уравнение, один корень");
        Methods.printInfo( new FirstEquation() );
    }
}
