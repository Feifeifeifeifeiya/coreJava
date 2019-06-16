import java.util.*;

/**
 * @ClassName collection
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/22 0022 9:32
 * @Version 1.0
 **/
public class collection {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        Stack<String> strings1 = new Stack<>();
        Map<Object, Object> hashMap = new HashMap<>();
        HashSet<String> strings2 = new HashSet<>();
        Collections.synchronizedMap(hashMap);
        hashMap.put("key","value");
        StringBuffer stringBuffer = new StringBuffer();
    }
}
