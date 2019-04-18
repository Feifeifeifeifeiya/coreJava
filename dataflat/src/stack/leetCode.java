package stack;

import java.util.Stack;

public class leetCode {
    public boolean isValid(String s) {
        Stack<Object> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{'||c=='('||c=='['){
                stack.push(c);
            }
            //判断栈顶元素
            char pop = (char)stack.pop();
            if(c==')'&&pop!='('){
                return false;
            }
            if(c==']'&&pop!='['){
                return false;
            }
            if(c=='}'&&pop!='{'){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        leetCode leetCode = new leetCode();
        boolean valid = leetCode.isValid("{[()]}");
        System.out.println(valid);
    }

}
