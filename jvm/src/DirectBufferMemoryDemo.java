/**
 * @ClassName DirectBufferMemoryDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/10 0010 16:44
 * @Version 1.0
 **/
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectmemory"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
    }
}
