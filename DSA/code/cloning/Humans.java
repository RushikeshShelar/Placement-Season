package cloning;

public class Humans implements Cloneable {
    int age;
    String name;
    int[] arr;

    public Humans(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{3,4,5,6,7};
    }

    public Humans(Humans other) {
        this.age = other.age;
        this.name = other.name;
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException {
////        This is Shallow Copy
//        return super.clone();
//    }

    @Override
    public Object clone() throws CloneNotSupportedException {
//        This is DEEP Copy
        Humans twin = (Humans)super.clone(); //This is Actually Shallow Copy

//        Make a Deep Copy
        twin.arr = new int[twin.arr.length];
        System.arraycopy(this.arr,0,twin.arr,0,twin.arr.length);
        return twin;
    }
}
