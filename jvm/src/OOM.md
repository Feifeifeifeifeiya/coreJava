
java.lang.stackOverFlowError
深度的方法调用超过栈空间的大小

java.lang.OutOfMemoryError:java heap space
创建对象过多或者对象（比如数组）创建过大，超过堆空间的大小

java.lang.OutOfMemoryError:GC overhead limit exceeded
大量的对象被装载，很大的资源用在垃圾回收上，并且回收效果不理想，GC超过最大极限

java.lang.OutOfMemoryError:Direct buffer memory
写NIO时可以直接在本地内存上分配空间，不属于GC的管辖范围，但如果不断的分配本地内存，堆内存很少使用，那么jvm不需要执行gc，
DirectByteBuffer对象们不会被回收，这时候堆内存充足，但是本地内存被用光了，再次尝试分配本地内存就会出现OutOfMemory

java.lang.OutOfMemoryError:unable to create new native thread
已达到创建线程的上限，不能够创建更多了，一个进程创建的线程超过系统的上限
解决方案：1少创建几个线程
        2调整服务器参数：vim /etc/security/limits.d/90-nproc.conf
        

java.lang.OutOfMemoryError:Metaspace
元空间使用本地内存
元空间存放了以下信息（方法区存在于元空间中）：
1.虚拟机加载的类信息
2.常量池
3.static变量
4.即时编译后的代码
模拟Metaspace空间溢出，只需要不断生成静态的类往元空间注入，类占据的空间总会超过Metaspace的大小