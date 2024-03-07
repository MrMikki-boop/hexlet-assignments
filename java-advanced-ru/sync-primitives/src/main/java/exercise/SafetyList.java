package exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SafetyList {
    // BEGIN
    private int[] array;
    private int size;
    private final Lock lock = new ReentrantLock();

    public SafetyList() {
        array = new int[10]; // Начальный размер массива
        size = 0;
    }

    public void add(int value) {
        lock.lock();
        try {
            if (size == array.length) {
                // Увеличиваем размер массива при необходимости
                int[] newArray = new int[array.length * 2];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
            array[size++] = value;
        } finally {
            lock.unlock();
        }
    }

    public int get(int index) {
        return array[index];
    }

    public int getSize() {
        return size;
    }
    // END
}
