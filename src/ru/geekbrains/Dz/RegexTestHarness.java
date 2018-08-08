package ru.geekbrains.Dz;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        Console console = System.console();
//        if (console == null) {
//            System.err.println("No console.");
//            System.exit(1);
//        }
        while (true) {
            System.out.println("%nEnter your regex: ");
            Pattern pattern =
                    Pattern.compile(scanner.nextLine());
//            Pattern pattern =
//                    Pattern.compile(console.readLine("%nEnter your regex: "));
            System.out.println("Enter input string to search: ");
            Matcher matcher =
                    pattern.matcher(scanner.nextLine());
//            Matcher matcher =
//                    pattern.matcher(console.readLine("Enter input string to search: "));

            boolean found = false;
            while (matcher.find()) {

                System.out.printf("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if(!found){
                System.out.println("No match found.%n");
            }
        }
    }
}
