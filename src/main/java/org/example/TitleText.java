package org.example;

public class TitleText {
    /**
     * Преобразование слова в формат "lowercase" с первой заглавной буквой
     *
     * @param text слово для преобразования
     * @return возвращает преобразованное слово
     */
    public static String titleText(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}
