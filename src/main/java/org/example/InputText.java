package org.example;

import java.util.Scanner;

public class InputText {
    /**
     * Ввод текста
     *
     * @return возвращает введеную строку
     */
    public static String inputText() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
