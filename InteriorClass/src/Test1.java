public class Test1 {
    public static void main(String[] args) {
        Outter.Inner inner = new Outter().new Inner();
        inner.print();
    }
}

class Outter{
    private int a=1;
    class Inner{
        private int a=2;
        public void print(){
            int a=3;
            System.out.println("局部变量"+a);
            System.out.println("内部类变量"+this.a);
            System.out.println("外部类变量"+Outter.this.a);
        }
    }
}
