package hashTable;


import java.util.TreeMap;

public class HashTable<K extends Comparable,V> {

    private final int[] capacity={53,97,13,389,769,1543,3079,6151,12289,24593,49157,98317,196613,393241,786433,1572869,3145739,6291469,12592917,25165843,50331653,100663319,201326611,402653189,805306457,1610612741};
    private static final int UPPERTOL=10;
    private static final int LOWERTOL=2;
    private int capacityIndex=0;

    private TreeMap<K,V>[] hashTable;
    private int M;  //hashTable的长度
    private int size; //存储了多少元素

    public HashTable(int M){
        this.M=capacity[capacityIndex];
        this.size=0;
        hashTable=new TreeMap[M];
        for(int i=0;i<M;i++){
            hashTable[i]=new TreeMap<>();
        }
    }



    //hash方法
    private int hash(K key)
    { //(key.hashCode()&0x7fffffff)这个是为了消除符号，因为int类型是有符号的。%M是为了找到这个key在这个hash表中的索引的过程
        return (key.hashCode()&0x7fffffff)%M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key,V value){
        TreeMap<K,V> map=hashTable[hash(key)];
        if(map.containsKey(key)){
            map.put(key,value);
        }else{
            map.put(key,value);
            size++;
        }
        if(size>=UPPERTOL*M&&capacityIndex+1<capacity.length){
            resize(capacity[capacityIndex+1]);
        }
    }

    public V remove(K key){
        if(!hashTable[hash(key)].containsKey(key)){
            return null;
        }else{
            V v = hashTable[hash(key)].remove(key);
            size--;
            if(size<LOWERTOL*M&&capacityIndex-1>=0){
                resize(capacity[capacityIndex-1]);
            }
            return v;
        }

    }

    private void resize(int newCapacity){
        TreeMap<K, V>[] newHashTable = new TreeMap[newCapacity];
        for(int i=0;i<newCapacity;i++){
            newHashTable[i]=new TreeMap<K,V>();
        }
        int oldM=M;
        this.M=newCapacity;
        for(int i=0;i<oldM;i++){
            TreeMap<K,V> map=hashTable[i];
            for(K key:map.keySet()){
                newHashTable[hash(key)].put(key,map.get(key));
            }
        }
        this.hashTable=newHashTable;
    }

    public void set(K key,V value){
        TreeMap<K,V> map=hashTable[hash(key)];
        if(!map.containsKey(key)){
            throw new IllegalArgumentException("key不存在");
        }else{
            map.put(key,value);
        }
    }

    public boolean contains(K key){
        TreeMap<K,V> map=hashTable[hash(key)];
        if(map.containsKey(key)){
            return true;
        }
        return false;
    }

    public V get(K key){
        return hashTable[hash(key)].get(key);
    }


}
