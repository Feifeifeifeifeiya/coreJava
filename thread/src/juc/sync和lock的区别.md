synchronized和Lock的区别？用新的Lock用什么好处？
1.原始构成：
   1.sync是关键字属于jvm层面，编译成字节码是有两个指令
        monitorenter和monitorexit（底层是通过monitor对象完成的，wait和notify等方法也依赖于monitor对象，所以只有在同步方法或是同步代码块中才能使用）
    
   2.lock是具体的类属于api层面
 
2.使用方法：
   1.sync不需要手动释放锁，同步代码执行完成后，系统会自动释放对锁的占用
   2.lock需要手动释放锁
 
3.是否可中断：
   1.sync除非抛出异常否则不可中断
   2.lock可中断1.设置超时方法trylock()
              2.lockinterruptibly()放在代码块中，调用interrupt()方法中断
              
4.是否是公平锁：
   1.sync非公平锁
   2.lock默认非公平锁，可以修改构造方法参数为true为公平锁

5.绑定多个条件的condition：
   1.sync没有
   2.lock可以实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像sync要么唤醒一个要么唤醒全部