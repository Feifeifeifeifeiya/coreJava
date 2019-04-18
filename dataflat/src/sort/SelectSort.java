package sort;

import java.util.Arrays;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/15 0015 0:35
 * @Version 1.0
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,7,2,9,4,1,0,5,7};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        //遍历所有的数
        for (int i=0;i<arr.length;i++){
            int miniIndex = i;
            //把当前遍历的数与他后面的数依次进行比较，并记录下最小数的下标
            for (int j=i+1;j<arr.length;j++){
                //如果后面有比当前数小的数记录下下标
                if(arr[miniIndex]>arr[j]){
                    miniIndex = j;
                }
            }
            //当i!=miniIndex时说明，后面有比当前遍历数小的数，这时交换他们的位置
            if(i!=miniIndex){
                int temp = arr[i];
                arr[i] = arr[miniIndex];
                arr[miniIndex] = temp;
            }
        }
    }
}
