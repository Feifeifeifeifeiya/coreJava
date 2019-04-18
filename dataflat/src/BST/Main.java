package BST;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        BST<Integer> bst = new BST<Integer>();
//        int[] nums={5,3,6,9,8,4,2,1};
//        for(int i=0;i<nums.length;i++){
//            bst.add(nums[i]);
//        }
//        bst.PreOrder();
//        System.out.println("--------------------");
//       bst.preOrderNR();
//        System.out.println("--------------------");
//        bst.layerOrder();
//        System.out.println("--------------------");

        BST<Integer> bst = new BST<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        int n=1000;
        for(int i=0;i<n;i++){
            bst.add(random.nextInt(100000));
        }
        while (!bst.isEmpty()){
            list.add(bst.removeMini());
        }
        System.out.println(list);
    }
}
