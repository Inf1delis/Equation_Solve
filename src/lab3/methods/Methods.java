package lab3.methods;

import lab3.equations.EquationInterface;
import lab3.main.Main;

public class Methods {

    public static int roots (MethodInterface method, double[] borders) {
        int counter = 0;

        for (int i = 0; i < borders.length -1; i++) {
            counter += method.solve(borders[i], borders[i+1]);
        }
        return counter;
    }

    public static void printInfo(EquationInterface equation) {
        Main.out.print("Биссекции:");
        equation.bisection();
        Main.out.print("Хорды:");
        equation.hords();
        Main.out.print("Параболы: ");
        equation.paraboles();
        Main.out.print("Ньютон:");
        equation.newton();

        Main.out.print(" ");
    }
}
