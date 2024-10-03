package StackQueues.queue;

public class CustomQueue {
    private int[] data;

    private static final int DEFAULT_SIZE = 10;

    int rear = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.data = new int[size];
    }


    public boolean isFull(){
        return rear == data.length;
    }

    public boolean isEmpty(){
        return rear == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }

        data[rear++] = item;
        return true;
    }

    public int remove() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Queue is Empty");
        }

        int removed = data[0];

//        Shift the Element to left
//        for(int i = 1; i < rear; i++){
//            data[i-1] = data[i];
//        }
        System.arraycopy(data,1,data,0,rear - 1);
        rear--;
        return  removed;
    }

    public int front() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty");
        }

        return data[0];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        for(int i = 0; i < rear; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println("END");
    }
}
