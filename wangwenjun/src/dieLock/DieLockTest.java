package dieLock;

public class DieLockTest {

    public static void main(String[] args) {

        DieLock1 dieLock1 = new DieLock1();
        DieLock2 dieLock2 = new DieLock2(dieLock1);
        dieLock1.setDieLock2(dieLock2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    dieLock1.m1();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    dieLock2.d2();
                }
            }
        }).start();
    }
}
