package Array;

import java.util.function.Predicate;

/**
 * @ClassName TwoFind
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/14 0014 21:21
 * @Version 1.0
 **/
public class TwoFind {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int mid = (arr.length-1)/2;
        int begin = 0;
        int end = arr.length-1;
        int targrt = 0;
        int index = -1;
        while (true){
            if(begin == end || begin >end){
                return;
            }
            if(arr[mid] == targrt){
                index = mid;
                break;
            }else{
                if(arr[mid] < targrt){
                    begin = mid +1;
                }else {
                    end = mid - 1;
                }
            }
            mid = (begin+end)/2;
        }
        System.out.println(index);
    }
}
