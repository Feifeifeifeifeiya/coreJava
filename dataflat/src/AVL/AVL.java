package AVL;

import java.util.*;

public class AVL<K extends Comparable<K>, V> {


    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public int height;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
            this.height=1;
        }
    }

    private Node root;
    private int size;

    public AVL(){
        root=null;
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return root==null;
    }

    private int getHeight(Node node){
        if(node==null){
            return 0;
        }
        return node.height;
    }

    //检查AVL还是否满足二分搜索树的性质
    public boolean isBST(){
        List<K> keys = new ArrayList<>();
        inorder(root,keys);
        for(int i=0;i<keys.size();i++){
            if(keys.get(i-1).compareTo(keys.get(i))>0){
                return false;
            }
            return true;
        }
        return true;
    }

    private void inorder(Node node,List<K> keys){
        if(node==null){
            return;
        }
        inorder(node.left,keys);
        keys.add(node.key);
        inorder(node.right,keys);
    }

    //判断这个二叉树是否有是一个平衡二叉树
    public boolean isBalend(){
        return isBalend(root);
    }

    private boolean isBalend(Node node){
        if(node==null){
            return true;
        }
        int balenceFactor = getBalenceFactor(node);
        if(Math.abs(balenceFactor)>1){
            return false;
        }
        return isBalend(node.left)&&isBalend(node.right);
    }

    //计算每一个节点的平衡因子
    private int getBalenceFactor(Node node){
        if(node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }

    //右旋转
    private Node rightRotate(Node y){
        Node x=y.left;
        Node T3=x.right;
        x.right=y;
        y.left=T3;
        //更新Height,更新时从下面往上面更新
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        return x;
    }

    //左旋转
    private Node leftRotate(Node x){
        Node y=x.right;
        Node T1=y.left;
        y.left=x;
        x.right=T1;
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        return y;
    }

    //向二分搜索树中添加新的元素
    public void add(K key,V value){
        root=add(root,key,value);
    }

    private Node add(Node node,K key,V value){

        if(node==null){
            node=new Node(key,value);
            size++;
            return node;
        }
        if(key.compareTo(root.key)<0){
            root.left=add(node.left,key,value);
        }
        else if (key.compareTo(root.key)>0){
            root.right=add(node.right,key,value);
        }
        else{
            node.value=value;
        }

        //更新height，就是选择左右子树中的最大值加1
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));
        //更新平衡因子
        int balenceFactor = getBalenceFactor(node);
        //判断是否满足平衡二叉树的条件，大于一说明不满足
        if(Math.abs(balenceFactor)>1){
            System.out.println(balenceFactor);
        }
        //平衡维护
        //ll
        if(balenceFactor>1&&getBalenceFactor(node.left)>=0){
            //左边节点的，进行右旋转
            return rightRotate(node);
        }
        //rr
        if(balenceFactor<-1&&getBalenceFactor(node.right)<=0){
            return leftRotate(node);
        }
        //lr
        if(balenceFactor>1&&getBalenceFactor(node.left)<0){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        //rl
        if(balenceFactor<-1&&getBalenceFactor(node.right)>0){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

}
