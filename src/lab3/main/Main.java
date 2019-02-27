package lab3.main;

import lab3.equations.FirstEquation;
import lab3.equations.SecondEquation;
import lab3.equations.ThirdEquation;
import my_classes.out.ConsoleOut;
import my_classes.out.Out;

public class Main {
    public static Out out = new ConsoleOut();

    public static void main(String[] args) {
        FirstEquation first = new FirstEquation();
        SecondEquation second = new SecondEquation();
        ThirdEquation third = new ThirdEquation();

        first.printAll();
        second.printAll();
        third.printAll();

        }


}
