package sort;

import java.util.Arrays;

/**
 * @ClassName RecursionAndMergeSort
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/15 0015 0:59
 * @Version 1.0
 **/
public class RecursionAndMergeSort {
    public static void main(String[] args) {
        int[] arr = {5,7,2,9,4,1,0,5,7};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //归并排序
    public static void mergeSort(int[] arr,int low,int high){
        int middle = (high+low)/2;
        if(low<high){
            //处理左边
            mergeSort(arr,low,middle);
            //处理右边
            mergeSort(arr,middle+1,high);
            //归并
            merge(arr,low,middle,high);
        }
    }

    public static void merge(int[] arr,int low,int middle,int high){
        //用于存储归并后的临时数组
        int[] temp = new int[high-low+1];
        //记录第一个数组需要遍历的下标
        int i = low;
        //记录第二个数组需要遍历的下标
        int j = middle+1;
        //用于记录在临时数组中存放的下标
        int index = 0;
        //遍历两个数组取出小的数字，放入临时数组中
        while (i<=middle&&j<=high){
            //第一个数组的数据更小
            if(arr[i]<=arr[j]){
                //把小的数据放入到临时变量中
                temp[index++] = arr[i++];
                //让下标往后移动一位
                i++;
            }else {
                temp[index++] = arr[j++];
                j++;

            }
        }
        //处理多余的数据
        while (j<=high){
            temp[index++] = arr[j++];

        }
        while (i<middle){
            temp[index++] = arr[i++];
        }
        //把排好序的数组重新指向原来的数组
        for (int k=0;k<index;k++){
            arr[k+low] = temp[k];
        }
    }
}
