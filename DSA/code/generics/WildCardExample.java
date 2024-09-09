package generics;

import java.util.Arrays;

//HEre T should be Either Number or its SubClasses
public class WildCardExample<T extends Number> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; //Also Working as Index Value

    public WildCardExample() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T element) {
        if (this.isFull()) {
            this.resize();
        }
        this.data[size++] = element;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public T get(int index) {

        return (T) (data[index]);
    }

    public int size() {
        return data.length;
    }

    public void set(int index, T value) {

        data[index] = value;
    }

    public T remove() {
        return (T) (data[--size]);
    }

    @Override
    public String toString() {
        return "CustomArrayList{" + "data" + Arrays.toString(data) + ", Size = " + size + '}';
    }

    public static void main(String[] args) {
        WildCardExample<Integer> list = new WildCardExample<>();
        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }


        System.out.println(list);

    }

}
