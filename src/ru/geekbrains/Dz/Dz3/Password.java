package ru.geekbrains.Dz.Dz3;

/*Необходимо из консоли считать пароль и проверить валидность,
результат будет true или false

Требования:
1. Пароль должен быть не менее 8ми символов.
2. В пароле должно быть число
3. В пароле должна быть хотя бы 1 строчная буква
4. В пароле должна быть хотя бы 1 заглавная буква*/


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        System.out.println("Придумайте пароль, в нём должно быть не менее 8ми символов, должно" +
                " присутствовать число, хотя бы 1 строчная и 1 заглавная буква");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(check(s));
    }


    private static boolean check(String s) {
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-zа-я])(?=.*[A-ZА-Я]).{8,}$");
        Matcher m = p.matcher(s);
        return m.matches();

    }

}