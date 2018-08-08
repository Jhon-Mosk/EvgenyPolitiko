package ru.geekbrains.Dz;

import java.lang.reflect.Field;

public class Reflection {
    static class A{
        private String field = "I'm private field";
    }

    static class B{
        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
            A a = new A();
            Field f = A.class.getDeclaredField("field");
            f.setAccessible(true);
            String fieldValue = (String)f.get(a);
            System.out.println(fieldValue);
        }
    }
}
