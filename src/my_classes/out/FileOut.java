package my_classes.out;

import work.projects.stackCalc.StackCalc;

import java.io.FileWriter;
import java.io.IOException;

public class FileOut implements Out {
    private FileWriter fileOut;

    public FileOut (String fileName) {

        try {
            fileOut = new FileWriter(fileName);
        } catch (IOException e) {
            StackCalc.out = new ConsoleOut();
            StackCalc.out.print("Ошибка вывода в файл");
        }
    }

    @Override
    public void print (Object data) {
        try {
            fileOut.write((String) data);
            fileOut.flush();

        } catch (IOException e) {
            StackCalc.out = new ConsoleOut();
            StackCalc.out.print("Ошибка вывода в файл");
        }
    }
}
