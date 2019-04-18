package Array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array();
        for(int i=0;i<10;i++){
            array.addLast(i);
        }
        for(int i=0;i<5;i++){
            array.addLast(i);
        }
        System.out.println(array);
       for(int i=0;i<12;i++){
           array.removeLast();
       }
        System.out.println(array);
    }
}
