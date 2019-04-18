package sort;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/14 0014 22:33
 * @Version 1.0
 **/
public class BubbleSort {
    //两两比较，外面的循环控制轮数，里面的循环控制次数
    public static void main(String[] args) {
        int[] arr = {5,7,2,9,4,1,0,5,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    /**
     *@Author WuFei
     *@Description //TODO
     *@Date 22:33 2019/3/14 0014
     *@Param
     *@Return
     **/
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
