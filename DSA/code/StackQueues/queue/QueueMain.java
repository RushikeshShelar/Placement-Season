package StackQueues.queue;

public class QueueMain {
    public static void main(String[] args) throws QueueException {
//        CustomQueue queue = new CustomQueue(5);
//
//        queue.insert(10);
//        queue.insert(20);
//        queue.insert(30);
//        queue.insert(40);
//        queue.insert(50);
//
//        queue.display();
//
//        System.out.println(queue.remove());
//        queue.display();
//
//        System.out.println(queue.remove());
//        queue.display();
//
//        System.out.println(queue.remove());
//        queue.display();
//
//        System.out.println(queue.remove());
//        queue.display();
//
//        System.out.println(queue.remove());
//        queue.display();
//
//        System.out.println(queue.remove());


//        Circular Queue
        CircularQueue cq = new CircularQueue(5);

        cq.insert(10);
        cq.insert(20);
        cq.insert(30);
        cq.insert(40);
        cq.insert(50);

        cq.display();

        cq.remove();
        cq.remove();
        cq.remove();
        cq.insert(99);
        cq.display();
    }
}
