package StackQueues.stack;

import java.util.Stack;

public class DynamicStack extends CustomStack {
    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item) {
        if(this.isFull()){
//            Double the Arr Size
            int[] temp = new int[data.length * 2];

//            Copy All the elements in new Arr
            System.arraycopy(data, 0, temp, 0,data.length);

            data = temp;
        }

        super.push(item);
        return true;
    }
}
