package org.example;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFiles {

    /**
     * Сохранение файла
     *
     * @param arr массив данных для сохранения в файл
     */
    public static void saveFile(String[] arr) {
        String fileFormat = ".txt";
        String dirName = "src/main/java/org/example/Files/";
        String fullNameFile = dirName + arr[0] + fileFormat;
        String text = "<" + String.join("><", arr) + ">";
        try (
                FileWriter writer = new FileWriter(fullNameFile, true);
                BufferedWriter bF = new BufferedWriter(writer)
        ) {
            bF.write(text);
            bF.newLine();
        } catch (FileNotFoundException ex) {
            System.err.println("Отсутствует директория " + dirName);
        } catch (IOException ex) {
            System.err.println("Ошибка создания/записи файла");
            ex.printStackTrace();
        }
    }
}
