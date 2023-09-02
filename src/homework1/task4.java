package homework1;

import java.io.IOException;
import java.util.Scanner;

public class task4 {
    //Разработайте программу, которая выбросит Exception, когда пользователь
    // вводит пустую строку. Пользователю должно показаться сообщение, что
    // пустые строки вводить нельзя.
    public static void main(String[] args) throws Exception {
        readLine();
    }

    public static void readLine() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        if (result.equals("")) {
            throw new Exception("Пустые строки вводить нельзя!");
        }
    }
}
