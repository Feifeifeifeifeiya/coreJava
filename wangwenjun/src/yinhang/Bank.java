package yinhang;

public class Bank implements Runnable{

    private final int MAX=50;

    private  int index=1;


    @Override
    public void run() {
//        while (index<=MAX){
//            try {
//                Thread.sleep(100);
//                System.out.println(Thread.currentThread().getName()+"当前号码是"+index++);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        while (true) {
            if (MAX < index) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "当前号码是" + index++);
        }
    }
}
