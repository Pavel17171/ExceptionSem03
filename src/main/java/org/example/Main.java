package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите текст в формате:\n\n" +
                           "Фамилия Имя Отчество дата_рождения номер_телефона пол\n\n" +
                           "Где:\n" +
                           "- дата рождения в формате дд.мм.гггг\n" +
                           "- номер телефона в числовом формате (без символов и пробелов)\n" +
                           "- пол женский: f\n" +
                           "- пол мужской: m\n");
        String text = InputText.inputText();
        System.out.println();
        String[] arr = ProcessedText.processedText(text);
        SaveFiles.saveFile(arr);
        System.out.println("Запись прошла УСПЕШНО");
    }
}