package generics;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; //Also Working as Index Value

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (this.isFull()) {
            this.resize();
        }
        this.data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];

        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public int get(int index) {
        return data[index];
    }

    public int size() {
        return data.length;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    public int remove() {
        return data[--size];
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data" + Arrays.toString(data) +
                ", Size = " + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();

        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }
        System.out.println(list.remove());
        System.out.println(list);

    }

}
