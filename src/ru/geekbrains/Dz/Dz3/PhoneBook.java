package ru.geekbrains.Dz.Dz3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    /*Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
    телефонных номеров. В этот телефонный справочник с помощью метода add() можно
    добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
    учесть, что под одной фамилией может быть несколько телефонов (в случае
однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.*/
    public static void main(String[] args) {

        SomePhoneBook book = new SomePhoneBook();
//book.printBook();
book.addNewPhone("196-92-24", "Шапочкина");
book.getSearch("Петров");

    }}
  class SomePhoneBook{
    Map<String, String> phoneBook = new HashMap<>();
    Set<Map.Entry<String, String>> set = phoneBook.entrySet();

      public SomePhoneBook() {

          phoneBook.put ("195-92-24", "Матросова");
          phoneBook.put("198-05-46", "Когтев");
          phoneBook.put("198-05-48", "Петров");
          phoneBook.put("198-15-48", "Петров");
          phoneBook.put("198-05-49",	"Сидоров");
          phoneBook.put("198-05-64",	"Сумин");
          phoneBook.put("198-05-73",	"Беликов");
          phoneBook.put("198-05-74",	"Терехова");
          phoneBook.put("198-06-09",	"Иванова");
          phoneBook.put("198-10-81",	"Пименов");
          phoneBook.put("198-14-21",	"Маслин");
          phoneBook.put("198-14-28",	"Пичугина");
          phoneBook.put("198-14-34",	"Зайцева");
          phoneBook.put("198-14-65",	"Баринова");
          phoneBook.put("198-14-77",	"Дынкина");
          phoneBook.put("198-14-90",	"Юдина");

      }
      void printBook(){
          for (Map.Entry<String, String> me: set) {
              System.out.println(me.getKey()+ " ===> " + me.getValue());

          }
      }

      public void addNewPhone(String s1, String s2) {
          phoneBook.put(s1, s2);
      }

      public void getSearch(String s) {
          for (Map.Entry<String, String> me: set){
              if(me.getValue().equalsIgnoreCase(s)){
                  System.out.println("Все номера " + s + " : " + me.getKey());
              }
          }
      }
  }

    


