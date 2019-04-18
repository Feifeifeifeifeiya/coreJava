package sort;

import javax.swing.*;
import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/14 0014 23:28
 * @Version 1.0
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5,7,2,9,4,1,0,5,7};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        //从下标1遍历整个数组（默认第一位是有序的）
        for (int i=1;i<arr.length;i++){
            //如果当前元素比前一个数字小
            if(arr[i]<arr[i-1]){
                //把当前遍历的数字存起来
                int temp = arr[i];
                int j=0;
                //遍历当前数字前面的所有数字(如果当前数大于他前面的数字就结束遍历)
                for (j=i-1;j>=0&&temp<arr[j];j--){
                    arr[j+1] = arr[j];
                }
                //不满足条件的时候需要把temp（外层for循环的当前元素）赋值给不满足条件的后一个元素
                arr[j+1] = temp;
            }
        }
    }
}
