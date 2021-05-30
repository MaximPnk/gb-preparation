package lesson2.task1;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.add(5);
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.indexOf(5));
    }

}
