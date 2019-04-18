package hashTable;

public class LeetCode387 {

    public static void main(String[] args) {
        int a=78;
        System.out.println(((Integer)a).hashCode());
        Student student = new Student(12, 10, "lisi", "haha");
        System.out.println(student.hashCode());
    }

    public int firstUniqueChar(String s){
        int[] ints = new int[26];
        //将a-z映射到数组中（asc-ll码）
        for(int i=0;i<ints.length;i++){
           ints[s.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++){
            if(ints[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;

    }
}
