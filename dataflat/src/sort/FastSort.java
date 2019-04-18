package sort;


import java.util.Arrays;

/**
 * @ClassName FastSort
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/14 0014 22:53
 * @Version 1.0
 **/
public class FastSort {
    //快速排序就是先找一个标准数，然后把高于标准数的放于标准数的右边，低于标准数的放于标准数的左边，然后把左右两边进行递归操作
    public static void main(String[] args) {
        int[] arr = {5,7,2,9,4,1,0,5,7};
        System.out.println(Arrays.toString(arr));
        fastSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void fastSort(int[] arr,int start,int end){
        if(start<end){
            //排序的标准数
            int stand = arr[start];
            //低于标准数的指针
            int low = start;
            //高于标准数的指针
            int high = end;
            //循环找出比标准数大的数和比标准数小的数
            while(low<high){
                //右边的数比标准数大
                while (low<high&&stand<=arr[high]){
                    high--;
                }
                arr[low] = arr[high];
                while (low<high&&arr[low]<stand){
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stand;
            fastSort(arr,start,low);
            fastSort(arr,low+1,end);
        }
    }
}
