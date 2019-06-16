import java.util.Stack;

/**
 * @ClassName Test3
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/20 0020 13:59
 * @Version 1.0
 **/
public class Test3 {
    public static void main(String[] args) {
        String s = "1-((((3+5)-(7+9))/2)+5*4)";
        //String s = "1-(((8.0-16.0)/2)+5*4)";

        String compute = compute(s);
    }

    private static String compute(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') {
                stack.push(c);
                if (Character.isDigit(charArray[c + 1])) {

                } else {

                    stack.pop();
                }
            }

        }
        return s;
    }
}
