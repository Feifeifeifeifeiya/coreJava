package queue;

import stack.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enQueue(E e) {
        array.addFirst(e);
    }

    @Override
    public E deQueue() {
        return array.removeLast();
    }

    @Override
    public E getFront() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Queue: ");
        sb.append("front: [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(i);
            if (i != array.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.deQueue();
                System.out.println(queue);
            }
        }

    }

}

