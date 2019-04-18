import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/15 0015 20:20
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Map<String, List<String>> lowMap = new HashMap<>();
        Map<String, Map<String, List<String>>> upMap = new HashMap<>();
        list.add("新华锦");
        list.add("美尔雅");
        list.add("中国中期");
        lowMap.put("概念解析",list);
        upMap.put("期货概念",lowMap);


        System.out.println(upMap);
    }
}
