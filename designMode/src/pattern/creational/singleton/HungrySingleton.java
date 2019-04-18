package pattern.creational.singleton;

import java.io.Serializable;

public class HungrySingleton implements Serializable {

    private static final HungrySingleton hungrySingleton;

    private HungrySingleton(){
        if(hungrySingleton != null){
            throw new RuntimeException("单例模式禁止反射暴力破解");
        }
    }
    static {
        hungrySingleton=new HungrySingleton();
    }
    public static HungrySingleton getInstnce(){
        return hungrySingleton;
    }
    private Object readResolve(){
        return hungrySingleton;
    }
}
