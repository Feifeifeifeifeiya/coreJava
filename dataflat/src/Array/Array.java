package Array;

public class Array<T> {

    private T[] data;

    private int size;

    public Array(int capacity){
        data=(T[]) new Object[capacity];
    }

    public Array(){
        this(10);
    }

    //获取数组中元素的个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size!=0;
    }

    //向所有元素的最后添加元素
    /*public void addLast(int t){
        if(size==data.length){
            throw new IllegalArgumentException("数组以满");
        }
        data[size]=t;
        size++;
    }*/
    public void addLast(T t){
        add(size,t);
    }

    //向所有元素的第一位添加元素
    /*public void addFirst(int t){
        for(int i=size-1;i>=0;i--){
            data[i+1]=data[i];
        }
        data[0]=t;
        size++;
    }*/
    public void addFirst(T t){
        add(0,t);
    }

    //向指定的位置添加元素
    public void add(int index,T t){
        //判断index是否非法
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        if(size==data.length){
            resize(2*data.length);
        }
        for(int i=size-1;i>index;i--){
            data[i+1]=data[i];
        }
        data[index]=t;
        size++;
    }



    //取出数组里的元素
    public T get(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("非法参数");
        }
        return data[index];
    }

    //数组元素的更新
    public void set(int index,T t){
        if(index<0||index>size){
            throw new IllegalArgumentException("非法参数");
        }
        data[index]=t;
    }

    //包含
    public boolean contains(T t){
        for(int i=0;i<size;i++){
            if(data[i]==t){
                return true;
            }
        }
        return false;
    }

    //搜索
    public int find(T t){
        for(int i=0;i<size;i++){
            if(data[i]==t){
                return i;
            }
        }
        return -1;
    }


    //删除(通过索引)
    public T remove(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("下标越界异常");
        }

        T ret=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        if(size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        size--;


        return ret;
    }

    //删除最后一个元素
    public T removeLast(){
        T ret = remove(size-1);
        return ret;
    }

    //删除第一个元素
    public T removeFirst(){
        T ret = remove(0);
        return ret;
    }

    //删除元素
    public void removeElement(T t){
        int i = find(t);
        if(i!=-1){
            remove(i);
        }
    }

    public boolean removeFromData(T t){
        int i = find(t);
        if (i==-1){
            return false;
        }
        remove(i);
        return true;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(data[i]);
            if(i!=size-1){
                sb.append(",");
            }

        }

        sb.append("]");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        T newData[]=(T[])new Object[newCapacity];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }
}
