package queue;

import java.util.Random;

public class Main {

    public static Long testQueue(Queue<Integer> q,int opCount){
        Random random = new Random();
        long l1 = System.nanoTime();
        for(int i=0;i<opCount;i++){
            q.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            q.deQueue();
        }
        long l2 = System.nanoTime();
        return l2-l1;
    }

    public static void main(String[] args) {
        int opCount=10000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println((Double) (testQueue(arrayQueue,opCount)/1000000000.0));
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println((Double) (testQueue(loopQueue,opCount)/1000000000.0));
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        System.out.println((Double) (testQueue(linkedQueue,opCount)/1000000000.0));
    }
}
