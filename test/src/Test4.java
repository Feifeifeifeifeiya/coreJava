import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName Test4
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/20 0020 14:08
 * @Version 1.0
 **/
public class Test4 {
    public static void main(String[] args) {
        //String s = "1-((((3+5)-(7+9))/2)+5*4)";
        String s = "1-((-8.0/2)+5*4)";

        String compute = compute(s);
    }

    private static String compute(String s) {
        if(!s.contains("*") && !s.contains("/") && !s.contains("+") && !s.contains("-")){
            return s;
        }
        int i = s.indexOf(')');
        int lastIndex = s.substring(0,i).lastIndexOf('(');
        int index = 0;
        double d = 0;
        String sub = s.substring(lastIndex+1,i);
        System.out.println(sub);
//        if(sub.contains("+") && sub.contains("*")){
//            int i1 = sub.indexOf("+");
//            int i2 = sub.indexOf("*");
//            if(i1<i2){
//                StringBuffer stringBuffer = new StringBuffer();
//                stringBuffer.append("(");
//                stringBuffer.append(sub.substring(i1+1,sub.length()));
//                stringBuffer.append(")");
//                sub = stringBuffer.toString();
//            }else{
//                sub = sub.substring(0,i1);
//            }
//        }
//        if(sub.contains("(")){
//            return compute(sub);
//        }
        if((0 < sub.indexOf("+") && sub.indexOf("+")< sub.length())){
            index = sub.indexOf("+");
            d = Double.parseDouble(sub.substring(0,index))+Double.parseDouble(sub.substring(index+1,sub.length()));
        }
        if((0 < sub.indexOf("-") && sub.indexOf("-")< sub.length())){
            index = sub.indexOf("-");
            d = Double.parseDouble(sub.substring(0,index))-Double.parseDouble(sub.substring(index+1,sub.length()));
        }
        if((0 < sub.indexOf("*") && sub.indexOf("*")< sub.length())){
            index = sub.indexOf("*");
            d = Double.parseDouble(sub.substring(0,index))*Double.parseDouble(sub.substring(index+1,sub.length()));
        }
        if((0 < sub.indexOf("/") && sub.indexOf("/")< sub.length())){
            index = sub.indexOf("/");
            d = Double.parseDouble(sub.substring(0,index))-Double.parseDouble(sub.substring(index+1,sub.length()));
        }
        String s1 = s.replace(s.substring(lastIndex,i+1),String.valueOf(d));
        System.out.println(s1);
 //       return compute(s1);
        return s;
        }

    }

