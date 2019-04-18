package priorityQueue;


import java.util.*;
import java.util.PriorityQueue;

public class LeetCode347 {
    /**
     *
     * @param nums 输入的数组
     * @param k 频次
     * @return 返回频次最高的k个元素
     */
    public List<Integer> topKFrequent(int[] nums, int k){

        //统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        //加入优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a,b)->map.get(a)-map.get(b)
        );
        for(int key:map.keySet()){
            if(queue.size()<k){
                queue.add(key);
            }else if(map.get(key)>map.get(queue.peek())){
                queue.remove();
                queue.remove(key);
            }
        }
        //将结果加入到list返回出去
        LinkedList<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){
            list.add(queue.remove());
        }
        return list;
    }
}
