package my_classes.logging;

public class ConsoleLoader implements ILog {

    @Override
    public void error (String message) {
        write(message);
    }

    @Override
    public void warn (String message) {
        write(message);
    }

    @Override
    public void trace (String message) {
        write(message);
    }

    @Override
    public void info(String message) {
        write(message);
    }

    @Override
    public void debug(String message) {
        write(message);
    }

    @Override
    public void fatal(String message) {
        write(message);
    }

    private void write (String message) {
        System.out.println(message + "\n");
    }
}
