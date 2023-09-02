package homework1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.println(getNumber());
    }

    public static float getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        try {
            float number = Float.parseFloat(scanner.nextLine());
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат");
        }
        return getNumber();
    }
}

