public class InheritInner extends WithInner.Inner{
    InheritInner(WithInner wi){
        wi.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner);
        inheritInner.fly();
    }
}


class WithInner{
    class Inner{
        void fly(){
            System.out.println("shabi");
        }
    }
}