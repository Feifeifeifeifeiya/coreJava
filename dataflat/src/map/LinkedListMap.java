package map;

import javax.swing.*;

public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(){
            this(null,null,null);
        }
    }

    private Node dummyNode;
    private int size;

    private Node getNode(K k){
        Node cur=dummyNode.next;
        while (cur!=null){
            if(cur.key.equals(k)){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if(node==null){
            Node node1 = new Node(k, v, dummyNode);
            node1.next=dummyNode.next;
            size++;
        }
    }

    @Override
    public V remove(K k) {
        Node node = getNode(k);
        if(node==null){
            throw new IllegalArgumentException("不存在该元素，无法删除");
        }

        return null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node==null?null:node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if(node==null){
            throw new IllegalArgumentException("该元素不存在");
        }
        node.value=v;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(K k) {
        V v = get(k);
        return v!=null;
    }
}
