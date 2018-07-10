package Lesson2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {
    public static void main(String[] args) {

        System.out.println(test("Java"));

    }

    public static boolean test(String testStr) {
        Pattern p = Pattern.compile("^Java$");
        Matcher m = p.matcher(testStr);

        return  m.matches();
    }
}
