package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessedText {

    /**
     * Проверка введенной строки на соответствие требованиям
     *
     * @return Возвращает массих объектов из строки
     * @throws Exception корректность ввода отдельных элементов
     */
    public static String[] processedText(String text) throws Exception {
        String[] arr = text.split("\\s+");
        if (arr.length != 6) {
            throw new Exception("Несоответствие в количестве данных");
        }
        if (!processedName(arr[0])) {
            throw new Exception("В ФАМИЛИИ должны быть только буквы");

        }
        if (!processedName(arr[1])) {
            throw new Exception("В ИМЕНИ должны быть только буквы");
        }
        if (!processedName(arr[2])) {
            throw new Exception("В ОТЧЕСТВЕ должны быть только буквы");
        }
        if (!processedDate(arr[3])) {
            throw new Exception("Некорректный ввод даты");
        }
        if (!processedNumber(arr[4])) {
            throw new Exception("Некорректный ввод номера телефона");
        }
        if (!processedGender(arr[5])) {
            throw new Exception("Формат пола не соответствует требованиям");
        }
        System.out.println("Проверка прошла УСПЕШНО");

        for (int i = 0; i < 3; i++) {
            arr[i] = TitleText.titleText(arr[i]);
        }

        return arr;
    }

    /**
     * Проверка есть ли в строке символы или цифры
     *
     * @param name Строка String
     * @return Если в строке только буквы, вернет "true"
     */
    public static boolean processedName(String name) {
        return name.matches("^[a-zA-Zа-яА-Я]+$");
    }

    /**
     * Проверка на ввод номера телефона (от 5 цифр)
     *
     * @param phone строка с номером телефона String
     * @return Если в строке только цифры и их количество >= 5, вернет "true"
     */
    public static boolean processedNumber(String phone) {
        return phone.matches("^[1-9]+$") && phone.length() >= 5;
    }

    /**
     * Проверка на правильность ввода пола
     *
     * @param gender гендер в формате String (f/m)
     * @return Если гендер введен корректно, вернет "true"
     */
    public static boolean processedGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }

    /**
     * Проверка даты на корректность
     *
     * @param dateText дата в вормате строки "дд.мм.гггг"
     * @return Если дата корректная и не позднее текущей даты, то вернет "true"
     */
    public static boolean processedDate(String dateText) {
        boolean flag = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date date = sdf.parse(dateText);
            if (date.before(new Date())) {
                flag = true;
            }
            if (!dateText.equals(sdf.format(date))) {
                flag = false;
            }
        } catch (ParseException ex) {
            flag = false;
        }
        return flag;
    }
}
