package StackQueues.queue;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue(){
        super();
    }

    public DynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if(this.isFull()){
//            Double the queue size
            int[] temp = new int[data.length * 2];

//            Copy the array Values
            for(int i = 0; i< data.length; i++){
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            rear = data.length;
            data = temp;
        }
        super.insert(item);
        return true;
    }
}
