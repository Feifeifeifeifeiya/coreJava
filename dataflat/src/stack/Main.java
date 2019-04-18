package stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        for(int i=0;i<5;i++){
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack);
        for(int i=0;i<2;i++){
            stack.pop();
        }
        System.out.println(stack);
        System.out.println(stack.peek());

        Stack<Object> linkedStack = new LinkedStack<>();
        for(int i=0;i<5;i++){
            linkedStack.push(i);
        }
        System.out.println(linkedStack.peek());
        System.out.println(linkedStack);
        for(int i=0;i<2;i++){
            linkedStack.pop();
        }
        System.out.println(linkedStack);
        System.out.println(linkedStack.peek());
    }
}
