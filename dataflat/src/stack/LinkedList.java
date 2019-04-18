package stack;

public class LinkedList<E> {

    private class Node<E>{
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

    private Node dummyHead;
    private int size;


    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }
    //获取链表的长度
    public int getSize(){
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向链表的头添加元素e
    public void addFirst(E e){
//        Node<E> node = new Node<>(e);
//        node.next=head;
//        head=node;
//        head=new Node<>(e,head);
//        size++;
          add(0,e);
    }

    //向链表的index位置添加元素e(借助数组的index思想)
    public void add(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("下标越界异常");
        }
        Node pre=dummyHead;
        for(int i=0;i<index;i++){
            pre=pre.next;
        }
        Node<E> node = new Node<>(e);
        node.next=pre.next;
        pre.next=node;
        size++;

    }

    //向链表的末尾添加元素e
    public void addLast(E e){
        add(size,e);
    }

    //通过下标获取元素e
    public E get(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("下标越界异常");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return (E) cur.e;
    }

    //获取第一个元素e
    public E getFirst(){
        return get(0);
    }

    //获取最后一个元素
    public E getLast(){
        return get(size-1);
    }

    //修改链表的第index个元素为e
    public void set(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("下标越界异常");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    //查看链表是否存在元素e
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //删除链表中下标为index的节点
    public E remove(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("下标越界异常");
        }
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node cur=prev.next;
        prev.next=cur.next;
        cur.next=null;
        size--;
        return(E) cur.e;
    }

    //从链表中删除第一个元素
    public E removeFirst(){
       return remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();

        for(Node cur=dummyHead.next;cur!=null;cur=cur.next){
            sb.append(cur+"->");
        }
        sb.append("null");
        return sb.toString();
    }
}
