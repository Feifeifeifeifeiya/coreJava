import priorityQueue.LeetCode347;

public class RBTree<K extends Comparable<K>,V> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;

        public Node(K key,V value){
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
            this.color=RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root=null;
        size=0;
    }

    //判断节点的颜色
    private boolean isRed(Node node){
        if(root==null){
            return BLACK;
        }
        return node.color;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //左旋转
    private Node leftRotate(Node node){
        Node x=node.right;
        node.right=x.left;
        x.left=node;
        x.color=node.color;
        node.color=RED;
        //返回旋转之后新的根节点
        return x;
    }

    //右旋转
    private Node rightRotate(Node node){
        Node y=node.left;
        node.left=y.right;
        y.right=node;
        y.color=node.color;
        node.color=RED;
        return y;
    }

    //颜色的翻转
    private void flipColors(Node node){
        node.color=RED;
        node.left.color=BLACK;
        node.right.color=BLACK;
    }

    //向红黑树中添加key，value
    public void add(K key,V value){
        add(root,key,value);
        root.color=BLACK;
    }

    private Node add(Node node,K key,V value){
        if(node==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }
        else if(key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }
        else {
            node.value=value;
        }
        //红黑树性质的维护
        if(isRed(node.right)&& !isRed(node.left)){
            node=leftRotate(node);
        }
        if(isRed(node.left)&& isRed(node.left.left)){
            node=rightRotate(node);
        }
        if(isRed(node.left)&&isRed(node.right)){
            flipColors(node);
        }

        return node;
    }

}
