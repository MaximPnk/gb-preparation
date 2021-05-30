package lesson2.task2;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println(list.size());
        list.addFirst(100);
        System.out.println(list);
        list.addLast(105);
        list.addFirst(90);
        list.add(1, 95);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        System.out.println(list.size());
        list.addFirst(90);
        list.addLast(110);
        System.out.println(list);
        list.remove(1);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());
        list.add(1, 100);
        list.add(1, 95);
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.get(1));

        System.out.println(list);
        System.out.println(list.indexOf(100));
    }
}
