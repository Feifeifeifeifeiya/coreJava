package pattern.creational.singleton;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ContainerSingleton {

    private ContainerSingleton(){}

    private static Map<String,Object>  singletonMap=new HashMap<>();

    public static void putInstance(String key,Object value){
        if(key.trim()!=null&& value!=null){
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key,value);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }
}
