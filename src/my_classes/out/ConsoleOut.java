package my_classes.out;

public class ConsoleOut implements Out {

    @Override
    public void print(Object obj1) {
        System.out.println(obj1);
    }
}