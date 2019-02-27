package my_classes.logging;

public interface ILog {
    void trace (String message); // 5
    void debug (String message); // 4
    void info (String message); // 3
    void warn (String message); // 2
    void error (String message); // 1
    void fatal (String message); // 0
}
