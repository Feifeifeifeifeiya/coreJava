package stack;

public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedStack(){
        linkedList=new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int length() {
        return linkedList.getSize();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Stack:linked[");
        sb.append(linkedList);
        sb.append("]");
        return sb.toString();
    }
}
