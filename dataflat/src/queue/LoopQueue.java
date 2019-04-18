package queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data=(E[]) new Object[capacity];
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public void enQueue(E e) {
        if((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        data[tail+1]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity){
        E[] newData=(E[])new Object[newCapacity*2];
        for(int i=0;i<size;i++){
            newData[i]=data[(i+front)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }

    @Override
    public E deQueue() {
        if(isEmpty()==true){
            throw new IllegalArgumentException("数组为空");
        }
        E cur=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4&&getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return cur;
    }



    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("数组为空");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }
}
