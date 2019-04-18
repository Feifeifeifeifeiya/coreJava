public class TestBired {

    public void test(Bired bired){
        System.out.println(bired.getName()+"能够飞"+bired.fly()+"米");
    }

    public static void main(String[] args) {
        TestBired testBired = new TestBired();
        testBired.test(new Bired() {
            @Override
            public int fly() {
                return 10000;
            }

            public String getName(){
                return "飞机";
            }
        });
    }
}
