/**
 * @ClassName TestGC
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/10 0010 2:43
 * @Version 1.0
 **/
// 如何查看一个正在运行的java程序，他的某个jvm参数是否开启？具体值是多少？
//  jps  查看java的后台进程
//  jinfo 正在运行的java程序的各种信息

// jinfo -flag PrintGCDetails 编号
// -XX:-PrintGCDetails 表示这个参数是关闭的

// 查看所有虚拟机目前能搜索到的所有信息：jinfo -flags

public class TestGC {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().totalMemory()); // 返回虚拟机的内存总量
        System.out.println(Runtime.getRuntime().maxMemory()); // 返回虚拟机试图使用的最大内存

        System.out.println("'********Test");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
