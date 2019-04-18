package stack;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack(){
        this.array=new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //用户想查看这个静态数组有多少容量
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int length(){
        return array.getSize();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Stack: [");
        for(int i=0;i<array.getSize();i++){
            sb.append(i);
            if(i!=array.getSize()-1){
                sb.append(",");
            }
        }
        sb.append("]:top ");
        return sb.toString();
    }

}
