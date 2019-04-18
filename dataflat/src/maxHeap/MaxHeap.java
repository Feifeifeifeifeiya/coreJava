package maxHeap;


public class MaxHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MaxHeap(int capacity){
        array=new Array<>(capacity);
    }

    public MaxHeap(){
        array=new Array<>();
    }

    //将一个完全二叉树变成一个最大堆
    public MaxHeap(E[] arr){
        array=new Array<>(arr);
        for(int i=parent(array.getSize()-1);i>=0;i++){
            SiftDown(i);
        }
    }

    //返回堆中的元素个数
    public int size(){
        return array.getSize();
    }

    //堆中的元素是否为空
    public boolean isEmpty(){
        return array.isEmpty();
    }

    //通过索引计算父亲节点的索引
    private int parent(int index){
        if(index==0){
            throw new IllegalArgumentException("该元素没有父亲节点");
        }
        return (index-1)/2;
    }

    //计算左孩子的节点的索引
    private int leftChild(int index){
        return index*2+1;
    }

    //计算右孩子的节点的索引
    private int rightChild(int index){
        return index*2+2;
    }

    //向堆中添加元素
    public void add(E e){
        array.addLast(e);
        siftUp(array.getSize()-1);
    }

    private void siftUp(int index){
        int parent = parent(index);
        while(index>0&&array.get(parent).compareTo(array.get(index))<0){
            array.swap(index,parent);
            index=parent;
        }
    }

    //查看堆中的最大元素
    public E findMax(){
        if(array.getSize()==0){
            throw new IllegalArgumentException("堆为空");
        }
        return array.get(0);
    }

    //取出堆的最大元素
    public E remove(){
        E max = findMax();
        array.swap(0,array.getSize()-1);
        array.removeLast();
        SiftDown(0);
        return max;
    }

    private void SiftDown(int index){
        while(leftChild(index)<array.getSize()){
            int j=leftChild(index);
            if(j+1<array.getSize()&&array.get(j+1).compareTo(array.get(j))>0){
                j=rightChild(index);
            }
            if(array.get(index).compareTo(array.get(j))<=0){
                break;
            }
            array.swap(index,j);
            index=j;
        }
    }

    //取出堆中的最大元素，替换成元素e
    public E replase(E e){
        E max = findMax();
        array.set(0,e);
        SiftDown(0);
        return max;
    }
}
