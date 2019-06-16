import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName Test5
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/20 0020 21:16
 * @Version 1.0
 **/
public class Test5 {
    public static void main(String[] args) {
        //String s = "1-((((3+5)-(7+9))/2)+5*4)";
        String s = "1-((-8.0/2)+5*4)";

        String compute = compute(s);
    }

    private static String compute(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            char c = charArray[i];
            if(c != '(' ){
                stack.push(c);
            }else{
                Character peek = stack.peek();
                if(peek!='('){
                    Character pop = stack.pop();
                    stringBuffer.append(pop);
                }
                Character pop = stack.pop();
                String s1 = stringBuffer.toString();
                //运算返回运算结果
                String operation = operation(s1);

            }
        }
        return s;
    }

    private static String operation(String s) {
        int i ;
        double d= 0;
        if(s.contains("+")){
            i = s.indexOf("+");
            d = Double.parseDouble(s.substring(0,i))+Double.parseDouble(s.substring(i+1,s.length()));
        }
        if(s.contains("-")){
            i = s.indexOf("-");
            d = Double.parseDouble(s.substring(0,i))-Double.parseDouble(s.substring(i+1,s.length()));
        }
        if(s.contains("8")){
            i = s.indexOf("*");
            d = Double.parseDouble(s.substring(0,i))*Double.parseDouble(s.substring(i+1,s.length()));
        }
        if(s.contains("/")){
            i = s.indexOf("/");
            d = Double.parseDouble(s.substring(0,i))/Double.parseDouble(s.substring(i+1,s.length()));
        }
        return String.valueOf(d);
    }
}
