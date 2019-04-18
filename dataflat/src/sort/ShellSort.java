package sort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/15 0015 0:05
 * @Version 1.0
 **/
public class ShellSort {
    //希尔排序就是把一个大的数组按照步长来分成几个小的数组来进行插入排序，然后将步长逐渐减小，直至变为一
    public static void main(String[] args) {
        int[] arr = {5,7,2,9,4,1,0,5,7};
        System.out.println(Arrays.toString(arr));
        shelltSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shelltSort(int[] arr) {
        //遍历所有的步长
        for(int d=arr.length;d>0;d/=2){
            //遍历所有的元素
            for(int i=d;i<arr.length;i++){
                //遍历本组中的元素
                for(int j=i-d;j>=0;j-=d){
                    if(arr[j]>arr[j+d]){
                        int temp = arr[j+d];
                        arr[j+d] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
