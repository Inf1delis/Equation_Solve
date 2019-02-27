package my_classes.logging;


import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Locale;

public class FileLoader implements ILog {
    private FileWriter file;

    public FileLoader(String fileName) {
        try {
            this.file = new FileWriter(fileName);

        } catch (IOException e) {
            System.out.println("Файла не существует!");
            throw new RuntimeException(e);
        }
    }

    private String getTime () {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        return df.toString();
    }

    @Override
    public void trace(String message) {

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
    public void warn(String message) {
        write(message);
    }

    @Override
    public void error(String message) {
        write(message);
    }

    @Override
    public void fatal(String message) {
        write(message);
    }


    private void write(String message) {
        try {
            file.write(message + "\n");
            file.flush();
        } catch (IOException e) {
            System.out.println("Файл поврежден!");
            throw new RuntimeException(e);
        }

    }
}
