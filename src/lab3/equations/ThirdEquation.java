package lab3.equations;

import lab3.methods.*;
import lab3.main.Main;

public class ThirdEquation implements EquationInterface {
    private double[] borders;

    public ThirdEquation() {
        borders = new double[3];
        borders[0] = 0;
        borders[1] = 0.45;
        borders[2] = 1;
    }

    @Override
    public double solve(double x) {
        double equation = Math.exp(x) - 1.59*x - 0.945;
        return equation;
    }

    @Override
    public double solveDiff(double x) {
        double equation = Math.exp(x) - 1.59;
        return equation;
    }

    @Override
    public void bisection() {
        ultimateOut( new Bisection(new ThirdEquation()) );
    }

    @Override
    public void hords() {
        ultimateOut( new Hords(new ThirdEquation()) );
    }

    @Override
    public void newton() {
        ultimateOut( new Newton(new ThirdEquation()) );
    }

    private void ultimateOut(MethodInterface method) {
        Main.out.print(String.format("Колличество итераций: %d\n", Methods.roots(method, borders)));
    }

    @Override
    public void paraboles() {
        ultimateOut( new Paraboles(new ThirdEquation()) );
    }

    @Override
    public void printAll() {
        Main.out.print("Третье уравнение, два кореня");
        Methods.printInfo( new ThirdEquation() );
    }
}
