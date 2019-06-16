package base;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/22 0022 23:45
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        swapInt(a,b);
        System.out.println(a+"/"+b);
        String s1 = "str1";
        String s2 = "str2";
        modifyString(s1,s2);
        System.out.println(s1+"/"+s2);
    }

    public static void swapInt(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static void modifyString(String s1,String s2){
        s1 = s1+s2;
        s2 = "str3";
    }
}
