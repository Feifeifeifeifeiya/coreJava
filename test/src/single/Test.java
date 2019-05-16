package single;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/15 0015 0:22
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Single2 instance = Single2.instance();
        Single2 instance1 = Single2.instance();
        instance.Single2();
        System.out.println(instance);
        System.out.println(instance1);
        String str1 = "hello";
        String str2 = "he"+new String("llo");
        System.out.println(str1==str2);
        System.out.println(str2);
        System.out.println(getValue(2));
    }

    public static int getValue(int i){
        int result = 0;
        switch (i){
            case 1:
                result = result + i;
            case 2:
                result = result +i*2;
            case 3:
                result = result +i*3;
        }
        return result;
    }
}
