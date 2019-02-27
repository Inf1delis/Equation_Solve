package lab3.equations;

import lab3.methods.*;
import lab3.main.Main;

public class SecondEquation implements EquationInterface {
    private double[] borders;

    public SecondEquation() {
        borders = new double[4];
        borders[0] = 0;
        borders[1] = 0.3;
        borders[2] = 0.48;
        borders[3] = 1;
    }

    @Override
    public double solve(double x) {
        double equation = Math.pow(x, 3) - 1.44*Math.pow(x,2) + 0.6203*x - 0.07866;
        return equation;
    }

    @Override
    public double solveDiff(double x) {
        double equation = 3*Math.pow(x,2) + 0.6203 - 2.88*x;
        return equation;
    }

    @Override
    public void bisection() {
        ultimateOut( new Bisection(new SecondEquation()) );
    }

    @Override
    public void hords() {
        ultimateOut( new Hords(new SecondEquation()) );
    }

    @Override
    public void newton() {
        ultimateOut( new Newton(new SecondEquation()) );
    }

    @Override
    public void paraboles() {
        ultimateOut( new Paraboles(new SecondEquation()) );
    }

    private void ultimateOut(MethodInterface method) {
        Main.out.print(String.format("Колличество итеераций: %d\n", Methods.roots(method, borders)));
    }

    @Override
    public void printAll() {
        Main.out.print("Второе уравнение, три кореня");
        Methods.printInfo( new SecondEquation() );
    }
}
