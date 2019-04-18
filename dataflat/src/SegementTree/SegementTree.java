package SegementTree;

public class SegementTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegementTree(E[] arr,Merger<E> merger){
        this.merger=merger;
        data=(E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
        tree=(E[])new Object[4*arr.length];
        buildSegementTree(0,0,data.length-1);
    }

    //在treeIndex的位置创建表示区间[l...r]之间的线段树
    public void buildSegementTree(int treeIndex,int l,int r){
        if(l==r){
            tree[treeIndex]=data[l];
            return;
        }
        int leftIndex=leftChild(treeIndex);
        int rightIndex=RightChild(treeIndex);
        int mid=l+(r-l)/2;
        buildSegementTree(leftIndex,l,mid);
        buildSegementTree(rightIndex,mid+1,r);
        tree[treeIndex]=merger.merge(tree[leftIndex],tree[rightIndex]);
    }

    //返回区间[queryl,queryr]的值
    public E query(int queryL,int queryR){
        if (queryL<0||queryL>=data.length||queryR<0||queryR>data.length||queryL>queryR){
            throw new IllegalArgumentException("我就想抛个异常");
        }
        return query(0,0,data.length-1,queryL,queryR);
    }

    private E query(int treeindex,int l,int r,int queryL,int queryR){
        if(queryL==l&&queryR==r){
            return tree[treeindex];
        }
        int leftIndex=leftChild(treeindex);
        int rightIndex=RightChild(treeindex);
        int mid=l+(r-l)/2;
        if(queryL>=mid+1){
            return query(rightIndex,mid+1,r,queryL,queryR);
        }else if(queryR<=mid){
            return query(leftIndex,l,mid,queryL,queryR);
        }
        E leftResult=query(leftIndex,l,mid,queryL,mid);
        E rightResult=query(rightIndex,mid+1,r,mid+1,queryR);
        E merge = merger.merge(leftResult, rightResult);
        return merge;
    }

    //将index位置的值更新为e
    public void set(int index,E e){
        if(index<0||index>data.length){
            throw new IllegalArgumentException("越界");
        }
        set(0,0,data.length-1,index,e);
    }

    private void set(int treeIndex,int l,int r,int index,E e){
        if(l==r){
            tree[treeIndex]=e;
            return;
        }
        int mid=l+(r-l)/2;
        int leftChild=leftChild(treeIndex);
        int RightChild=RightChild(treeIndex);
        if(index>=mid+1){
            set(treeIndex,mid+1,r,index,e);
        }else if(index<=mid){
            set(treeIndex,l,mid,index,e);
        }
        tree[treeIndex]=merger.merge(tree[leftChild],tree[RightChild]);
    }


    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index<0||index>getSize()){
            throw new IllegalArgumentException("下标非法");
        }
        return data[index];
    }

    //返回完全二叉树中的数组表示中，一个索引所表示的左孩子的索引
    public int leftChild(int index){
        return index*2+1;
    }

    //返回完全二叉树中的数组表示中，一个索引所表示的右孩子的索引
    public int RightChild(int index){
        return index*2+2;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i=0;i<tree.length;i++){
            if(tree[i]!=null){
                sb.append(tree[i]);
                sb.append("-->");
            }else{
                sb.append("null");
                sb.append("-->");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
