package my_classes.logging;


import java.util.Date;

public class Log {
    private ILog loadder;
    private int level; // 0 <= level <= 5


    public Log(String fileName, int level) {
        this.level = level;
        this.loadder = new FileLoader(fileName);
    }

    public Log(String fileName, String level) {
        this(fileName, 0);
        this.level = levelCheck(level);
    }


    public Log(String level) {
        this(0);
        this.level = levelCheck(level);
    }

    public Log (int level) {
        this.level = level;
        this.loadder = new ConsoleLoader();
    }



    private String time () {
        return new Date().toString();
    }



    public void trace(String message) {
        if (level == 5) loadder.trace( write(message) );
    }

    public void debug(String message) {
        if (level >= 4) loadder.debug( write(message) );
    }

    public void info(String message) {
        if (level >= 3) loadder.info( write( message) );
    }

    public void warn(String message) { if (level >= 2) loadder.warn( write(message) ); }

    public void error(String message) {
        if (level >= 1) loadder.error( write(message) );
    }

    public void fatal(String message) {
        if (level >= 0) loadder.fatal( write(message) );
    }

    private String write(String message) {
        return message + "  time: " + time();
    }

    private int levelCheck (String str) {
        str.toLowerCase();
        switch (str) {
            case "trace": return 5;
            case "debug": return 4;
            case "info": return 3;
            case "warn": return 2;
            case "error": return 1;
            case "fatal": return 0;
        }
        throw new RuntimeException("Уровень логгирования неверно задан!");
    }

}
