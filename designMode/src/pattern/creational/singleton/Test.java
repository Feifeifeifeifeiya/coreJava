package pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        LazySingleton instance = LazySingleton.getInstance();
//        Thread t1 = new Thread(new T());
//        Thread t2 = new Thread(new T());
//        t1.start();
//        t2.start();
//        System.out.println("哈哈");


//        HungrySingleton hungrySingleton = HungrySingleton.getInstnce();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton"));
//        oos.writeObject(hungrySingleton);
//
//        File file = new File("singleton");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        HungrySingleton newHungrySingleton = (HungrySingleton) ois.readObject();
//        System.out.println(hungrySingleton);
//        System.out.println(newHungrySingleton);
//        System.out.println(hungrySingleton==newHungrySingleton);

        Class<HungrySingleton> singletonClass = HungrySingleton.class;
        Constructor<HungrySingleton> constructor = singletonClass.getDeclaredConstructor();
        HungrySingleton instnce = HungrySingleton.getInstnce();
        constructor.setAccessible(true);
        HungrySingleton newInstance = constructor.newInstance();
        System.out.println(instnce);
        System.out.println(newInstance);
        System.out.println(instnce==newInstance);
    }
}
