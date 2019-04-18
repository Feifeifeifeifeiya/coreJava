package set;





import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e=e;
            this.left=null;
            this.right=null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        this.root=null;
        this.size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //向二分搜索树添加元素
    public void add(E e){
           root= add(root,e);


    }

    //向以node为根节点的树中添加元素e，递归算法
    //返回的是根节点
    private Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }
        if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;
    }

    //从二分搜索树查询元素
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    //二分搜索树的前序遍历
    public void PreOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

    //二分搜索树的层序遍历
    public void layerOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node==null){
            return;
        }
        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    //后序遍历
    public void latOrder(){
        latOrder(root);
    }

    private void latOrder(Node node){
        if(node==null){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    //寻找二分搜索树的最小值
    public E mininum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return mininum(root).e;
    }

    private Node mininum(Node node){
        if(node.left==null){
            return node;
        }
        return mininum(node.left);
    }

    //从二分搜索树中删除最小节点，返回最小值
    public E removeMini(){
        E mininum = mininum();
        root=removeMini(root);
        return mininum;
    }

    private Node  removeMini(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMini(node.left);
        return node;
    }

    //寻找二分搜索树的最大值
    public E maxnum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maxnum(root).e;
    }

    private Node maxnum(Node node){
        if(node.right==null){
            return node;
        }
        return maxnum(node.right);
    }

    //删除二分搜索树的最大值
    public E removeMax(){
        E maxnum = maxnum();
        removeMax(root);
        return maxnum;
    }

    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        node.right=removeMax(node.right);
        return node;
    }

    //从二分搜索树删除元素为e的节点
    public void remove(E e){
        root=remove(root,e);
    }

    private Node remove(Node node,E e){
        if(node==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }else{//e==node.e
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //左右子树都不为空
            Node mininum = mininum(node.right);
            mininum.right=removeMini(node.right);
            mininum.left=node.left;
            node.left=node.right=null;
            return mininum;
        }
    }
}
