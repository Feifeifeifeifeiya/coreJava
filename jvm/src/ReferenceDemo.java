import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @ClassName StrongReferenceDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/10 0010 15:12
 * @Version 1.0
 *
 *
 * Reference:默认的，强引用内存不够时也不会回收，死也不收
 * softReference：软引用 系统内存充足时不会回收，内存不足时会回收
 * weakReference:弱引用 只要有gc就会回收
 * phantomReference:虚引用 在任何时候都能被回收 ，要与ReferenceQueue一起使用
 **/
public class ReferenceDemo {
    public static void main(String[] args) {
        weak_Reference();
    }

    //强引用
    public static void strong_Reference(){
        Object obj1 = new Object();  //这样定义的就是强引用
        Object obj2 = obj1; //obj2引用赋值
        obj1 = null; // 置为空
        System.gc();
        System.out.println(obj2);
    }

    //软引用内存充足时
    public static void soft_Reference_memory_enough(){
        Object o1 = new Object();
        SoftReference<Object> reference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(reference.get());
        o1 = null; // 置为空
        System.gc();
        System.out.println(o1);
        System.out.println(reference.get());
    }

    //软引用内存不足时
    public static void soft_Reference_memory_not_enough(){
        Object o1 = new Object();
        SoftReference<Object> reference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(reference.get());

        o1 = null; // 置为空
        // System.gc();
        try {
            byte[] bytes = new byte[300*1024*1024];
        }catch (Exception e){
         e.getMessage();
        }finally {
            System.out.println(o1);
            System.out.println(reference.get());
        }

    }


    //弱引用
    public static void weak_Reference(){
        Object o1 = new Object();
        WeakReference<Object> reference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(reference.get());

        o1 = null; // 置为空
        System.gc();
        System.out.println(o1);
        System.out.println(reference.get());

    }

}
