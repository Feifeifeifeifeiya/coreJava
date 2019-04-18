package pattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class LazySingleton {
    private static LazySingleton lazySingleton=null;
    private static boolean flag=true;
    private LazySingleton(){
        if(flag){
            flag=false;
        }else{
            throw new RuntimeException("单例模式禁止反射暴力破解");
        }
    }

    public synchronized static LazySingleton getInstance(){
        if(lazySingleton==null){
            lazySingleton=new LazySingleton();
        }
        return lazySingleton;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //Class<?> aClass = Class.forName(LazySingleton.class.getName());
        Class<LazySingleton> singletonClass = LazySingleton.class;
        Constructor<LazySingleton> constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleton instance = LazySingleton.getInstance();

//        Field flag = singletonClass.getDeclaredField("flag");
//        flag.setAccessible(true);
//        flag.set(instance,true);
        LazySingleton newInstance = constructor.newInstance();



        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance==newInstance);
    }
}
