package ru.geekbrains.Lessons.Lesson3;

import java.util.*;

public class CollectionMain {
    public static void main(String[] args) {

//        int[] arr = {1,2,3,4,5};
//        System.out.println(Arrays.toString(arr));
//        int[] arr2 = new int[20];
//        System.arraycopy(arr, 0, arr2, 0, arr.length);
//        System.out.println(Arrays.toString(arr2));

//        ArrayList<Integer> ai = new ArrayList<Integer>();
//
//
//        ai.add(1);
//        ai.add(2);
//        ai.add(3);
//        ai.add(4);
//        ai.add(5);
//        ai.add(null);
//        ai.add(7);
//
//        System.out.println(ai);
//     //   System.out.println(ai.size());
//
//        ai.remove((Integer) 2);
//        System.out.println(ai);
//
//        for (int i = 0; i < ai.size(); i++) {
//            if(ai.get(i) == 7) {
//                System.out.println("Есть число 7");
//            }
//        }
//
//        if(ai.contains(7)) {
//            System.out.println("Есть число 7");
//        }


//        ArrayList<String> states = new ArrayList<String>();
//
//        states.add("Америка");
//        states.add("Германия");
//        states.add("Россия");
//        states.add("Франция");
//        states.add("Испания");
//        states.add("Испания");
//        states.add("Италия");
//
//        System.out.println(states);
//
//        for (int i = 0; i < states.size(); i++) {
//            System.out.println(states.get(i));
//            if(states.get(i).equalsIgnoreCase("Испания")) {
//                states.remove(i);
////                i--;
//            }
//        }
//        System.out.println(states);

//        Iterator<String> iter = states.iterator();
//
//        while (iter.hasNext()) {
//         //   System.out.println(iter.next());
//            if(iter.next().equalsIgnoreCase("Испания")) {
//                iter.remove();
//            }
//        }
//
//        System.out.println(states);


//        LinkedList<String> ll = new LinkedList<String>();
//
//        ll.addLast("END");
//        ll.add("A");
//        ll.add("B");
//        ll.add("C");
//        ll.add("D");
//        ll.add("E");
//
//        ll.addFirst("1");
//
//
//        System.out.println(ll);

//        Box b1 = new Box("White", 2);
//        Box b2 = new Box("White", 2);
//
//        System.out.println(b1.equals(b2));
//        ArrayList<String> al = new ArrayList<>();
//        al.add("Name Ivonal");
//        al.add("Surname Ivanovish");
//        al.add("age 10");

        Map<String, String> hmDocField = new HashMap<String, String>();
        Set<Map.Entry<String, String>> set = hmDocField.entrySet();


        hmDocField.put("name", "Ivonal");
        hmDocField.put("Surname", "Ivanovish");
        hmDocField.put("age", "10");

        for (Map.Entry<String, String> me: set) {
            System.out.println(me.getKey());
            System.out.println(me.getValue());
        }

        System.out.println(hmDocField);

//        Random random = new Random();
//        Map<Integer, Integer> hm = new HashMap<>();
//
//        for (int i = 0; i < 100; i++) {
//            int num = random.nextInt(10);
//            Integer res = hm.get(num);
//            hm.put(num, res == null ? 1 : res + 1);
//        }
//
//        System.out.println(hm);



//        HashSet<String> hs = new HashSet<String>();
//
//        hs.add("abc");
//        hs.add("abc");
//        hs.add("abc");
//        hs.add("abc1");
//        hs.add("abc2");
//        hs.add("abc3");
//        hs.add("abc4");
//        hs.add("abc5");
//
//        System.out.println(hs);


//        TreeSet<String> ts = new TreeSet<String>();
//
//        ts.add("Z");
//        ts.add("F");
//        ts.add("A");
//        ts.add("T");
//        ts.add("R");
//        ts.add("I");
//
//        System.out.println(ts);



    }
}



class Box {
    String color;
    int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Box) {
            Box another = (Box) obj;
            if(this.color.equalsIgnoreCase(another.color) &&
                    this.size == another.size) {
                return true;
            }
        }
        return false;
    }
}















