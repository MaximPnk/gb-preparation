package lesson2.task2;

public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    static class Node<E> {
        E item;
        Node<E> previous;
        Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    public void addFirst(E value) {
        if (size == 0) {
            last = first = new Node<>(value, null, null);
        } else {
            Node<E> second = first;
            first = new Node<>(value, null, second);
            second.previous = first;
        }
        size++;
    }

    public void addLast(E value) {
        if (size == 0) {
            first = last = new Node<>(value, null, null);
        } else {
            Node<E> preLast = last;
            last = new Node<>(value, preLast, null);
            preLast.next = last;
        }
        size++;
    }

    public void add(int index, E value) {
        checkIndex(index);
        Node<E> current = first;
        for (int i = 0; i < index; i++) current = current.next;
        Node<E> el = new Node<>(value, null, current);
        if (current.previous != null) {
            el.previous = current.previous;
            current.previous.next = el;
        }
        current.previous = el;
        size++;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            first = first.next;
            first.previous = null;
            size--;
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            last = last.previous;
            last.next = null;
            size--;
        }
    }

    public void remove(int index) {
        checkIndex(index);
        if (!isEmpty()) {
            Node<E> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (size == 1) {
                first = last = null;
            } else if (current.previous == null) {
                first = current.next;
                first.previous = null;
            } else if (current.next == null) {
                last = current.previous;
                last.next = null;
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            size--;
        }
    }

    //remove getIndex, indexOf
    public E get(int index) {
        checkIndex(index);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = first.next;
        }
        return current.item;
    }

    public int indexOf(E value) {
        int index = -1;
        if (!isEmpty()) {
            Node<E> current = first;
            for (int i = 0; i < size; i++) {
                if (current.item.equals(value)) {
                    return i;
                }
                current = current.next;
            }
        }
        return index;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("-----------").append(System.lineSeparator());
        Node<E> current = first;
        while (current != null) {
            res.append(current.item).append(System.lineSeparator());
            current = current.next;
        }
        res.append("-----------");
        return res.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

}
