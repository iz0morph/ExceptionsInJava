package finalProject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел в формате: " +
                                   "ФИО - строки;" +
                                   "дата рождения - dd.mm.yyyy;" +
                                   "номер телефона - цифры;" +
                                   "пол - символ 'f' или 'm'");
        String[] fullInfo = scanner.nextLine().split(" ");
        switch (checkQuantityOfArgs(fullInfo)) {
            case -1 ->
                    System.out.println("Введено меньше данных, чем ожидалось");
            case -2 ->
                    System.out.println("Введено больше данных, чем ожидалось");
            case 0 -> {
                try {
                    Person person = getInfo(fullInfo);
                    savePerson(fullInfo, person);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static Person getInfo(String[] fullInfo) throws Exception {
        String name = null;
        String secondName = null;
        String surName = null;
        String birthDate = null;
        long phoneNumber = 0;
        char sex = 0;
        for (int i = 0; i < fullInfo.length; i++) {
            if (phoneNumber == 0) {
                try {
                    phoneNumber = Long.parseLong(fullInfo[i]);
                    continue;
                } catch (NumberFormatException e) {
                    if (i == fullInfo.length - 1) throw new Exception(
                            "Неверный формат номера " + "телефона!");
                }
            }
            if ((fullInfo[i].equals("f") && fullInfo[i].length() == 1) ||
                    (fullInfo[i].equals("m") && fullInfo[i].length() == 1)) {
                sex = fullInfo[i].charAt(0);
                continue;
            }
            if (fullInfo[i].contains(".")) {
                birthDate = fullInfo[i];
                continue;
            }
            if ((name == null || secondName == null || surName == null)) {
                name = fullInfo[i];
                secondName = fullInfo[i + 1];
                surName = fullInfo[i + 2];
            }

        } if (name == null || secondName == null || surName == null) {
            throw new Exception("Неверно введены ФИО!");
        }
        if (birthDate == null) {
            throw new Exception("Неверно введена дата рождения!");
        }
        if (phoneNumber == 0) {
            throw new Exception("Неверно введен номер телефона!");
        }
        if (sex == 0) {
            throw new Exception("Неверно введен пол!");
        }
        return new Person(name, secondName, surName, birthDate, phoneNumber,
                          sex);
    }

    public static int checkQuantityOfArgs(String[] info) {
        if (info.length < 6) return -1;
        if (info.length > 6) return -2;
        return 0;
    }

    public static void savePerson(String[] info,
                                  Person person) throws IOException {
        try (FileWriter fileWriter = new FileWriter(person.getSecondName(),
         true                                           )) {
            for (String s : info) {
                fileWriter.write("<" + s + ">");
            }
            fileWriter.write("\n");
        }
    }
}


