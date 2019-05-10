/**
 * @ClassName GCRootsDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/10 0010 2:15
 * @Version 1.0
 *什么样的对象可以被回收？
 * 1.引用计数法（较难处理循环引用问题，一般不采用）
 * 2.枚举根节点做可达性分析（根搜索路径）
 * 在java中可以作为gc roots的对象有:
 * 1.虚拟机栈（栈帧中的本地变量表）中引用的对象
 * 2.方法区中类静态属性引用的对象
 * 3.方法区中常量引用的对象
 * 4.本地方法栈中引用的对象
 **/

public class GCRootsDemo {

    private byte[] bytes = new byte[100*1024*1024];


    public static void m1(){
        GCRootsDemo t1 = new GCRootsDemo();
        System.gc();
        System.out.println("第一次gc完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
