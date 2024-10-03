package StackQueues.queue;

public class CircularQueue {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    private int size;
    int rear = 0;
    int front = 0;


    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }


    public boolean isFull() {
        return size== data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }

        data[rear++] = item;
        rear = rear % data.length;
        size++;
        return true;
    }

    public int remove() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is Empty");
        }

        int removed = data[front++];
        front = front % data.length;
        size--;

        return removed;
    }

    public int front() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is Empty");
        }

        return data[front];
    }

   public void display(){
        if(isEmpty()){
            System.out.print("EMPTY");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i] + " <- ");
            i++;
            i %= data.length;
        }while (i != rear);
       System.out.println("END");
   }
}
