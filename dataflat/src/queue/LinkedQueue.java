package queue;

import javax.print.attribute.HashPrintRequestAttributeSet;

public class LinkedQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }

    }

    private Node head,tail;
    private int size;

    public LinkedQueue(){
        this.head=null;
        this.tail=null;
        this.size=0;

    }
    @Override
    public void enQueue(E e) {
        if(tail==null){
            tail= new Node(e);
            head=tail;
        }
        tail.next=new Node(e);
        tail=tail.next;
        size++;
    }

    @Override
    public E deQueue() {
        if(head==null){
            throw new IllegalArgumentException("链表为空");
        }
        Node delNode=head;
        head=head.next;
        delNode.next=null;
        if(head==null){
            tail=null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Queue:front:");
        Node cur=head;
        while (cur!=null){
            sb.append(cur);
            sb.append("->");
            cur=cur.next;
        }
        sb.append("null:tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        for(int i=0;i<10;i++){
            queue.enQueue(i);
            System.out.println(queue);
        }
        queue.deQueue();
        System.out.println(queue);
    }
}
