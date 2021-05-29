package lesson2.task1;

import java.util.Arrays;

public class MyArrayList<E> {

    private static final int CAPACITY = 10;
    private E[] array;
    private int size;

    public MyArrayList() {
        this(CAPACITY);
    }

    public MyArrayList(int size) {
        array = (E[]) new Object[size];
    }

    // add, get, size, remove

    public void add(E value) {
        checkLength();
        array[size++] = value;
    }

    public void add(int index, E value) {
        checkIndex(index);
        checkLength();
        if (index == size) {
            add(value);
        } else {
            if (size - index >= 0) System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = value;
            size++;
        }
    }

    public boolean remove(E value) {
        int index = indexOf(value);
        if (index != -1) {
            remove(index);
        }
        return index != -1;
    }

    public E remove(int index) {
        checkIndex(index);

        E value = array[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }

        array[size - 1] = null;
        size--;

        return value;
    }

    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            result.append(array[i]).append(", ");
        }
        result.append(array[size-1]);
        return result.toString();
    }

    private void checkLength() {
        if (array.length == size) {
            array = Arrays.copyOf(array, array.length + array.length / 2 + 1);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

}
