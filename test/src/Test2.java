import java.util.Stack;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/20 0020 11:11
 * @Version 1.0
 **/
public class Test2 {
    public static void main(String[] args) {
        //String s = "1-((((3+5)-(7+9))/2)+5*4)";
        String s = "1-((-8.0/2)+5*4)";

        String compute = compute(s);
    }

    private static String compute(String s) {
        if(!s.contains("*") && !s.contains("/") && !s.contains("+") && !s.contains("-")){
            return s;
        }
        int count = 0;
        int index = 0;
        Pattern compile = Pattern.compile("\\(([^\\(]+)\\)");
        Matcher matcher = compile.matcher(s);
        while (matcher.find()){
            String group = matcher.group();

            while ((index = group.indexOf(")",index)) != -1){
                index = index + ")".length();
                count ++;
            }
            if(count > 1){
                group = group.substring(0,group.indexOf(")")+1);
            }
            System.out.println(group);
            int  cc = 0;
            if(group.contains("+")){
                cc++;
            }
            if(group.contains("-")){
                cc++;
            }
            if(group.contains("*")){
                cc++;
            }
            if(group.contains("/")){
                cc++;
            }
            if(cc >1){
                int j = group.indexOf("+");
                int k = group.indexOf("-");
                int l = group.indexOf("*");
                int m = group.indexOf("/");
                if(j!=-1 && l!=-1){
                    group=group.substring(j+1,group.length()-1);
                }
                if(j!=-1 && m!=-1){
                    group=group.substring(j+1,group.length()-1);
                }
                if(k!=-1 && l!=-1){
                    group=group.substring(k+1,group.length()-1);
                }
                if(k!=-1 && m!=-1){
                    group=group.substring(k+1,group.length()-1);
                }
                if(j!=-1 && k!=-1){
                    group=group.substring(j+1,group.length()-1);
                }
                if(l!=-1 && m!=-1){
                    group=group.substring(l+1,group.length()-1);
                }
                System.out.println(group);
            }
            double i = 0;
            if(group.contains("+")){
                int c = group.indexOf("+");

                i = Double.parseDouble(String.valueOf(group.substring(1,c)))+Double.parseDouble(String.valueOf(group.substring(c+1,group.length()-1)));
            }
            else if(group.contains("-")){
                int c = group.indexOf("-");
                i = Double.parseDouble(String.valueOf(group.substring(1,c)))-Double.parseDouble(String.valueOf(group.substring(c+1,group.length()-1)));
            }else if(group.contains("*")){
                int c = group.indexOf("*");
                i = Double.parseDouble(String.valueOf(group.substring(1,c)))*Double.parseDouble(String.valueOf(group.substring(c+1,group.length()-1)));
            }else if(group.contains("/")){
                int c = group.indexOf("/");
                i = Double.parseDouble(String.valueOf(group.substring(1,c)))/Double.parseDouble(String.valueOf(group.substring(c+1,group.length()-1)));
            }
            s = s.replace(group, String.valueOf(i));
            System.out.println(s);
//            compute(s);
        }
        return s;
    }

}
