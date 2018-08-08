package ru.geekbrains.Dz;

public class StringBuild {
    public static void main(String[] args) {
        String str = "Предложение  один   Предложение       два  Предложение   три";
        String s1 = str.replaceAll(" +"," ");
        System.out.println(s1);

        StringBuilder sb =new StringBuilder(s1);

        for (int i = 1; i <s1.length() ; i++) {
if (s1.charAt(i)>= 'А' && s1.charAt(i)<= 'Я'){
    sb.setCharAt(i-1,'.');

}
        }

        for (int i = 1; i <sb.length() ; i++) {
            if (sb.charAt(i)=='.'){
                sb.insert(i+1, ' ');
            }

    }
        sb.insert(sb.length(),'.');
    System.out.println(sb);
}
}