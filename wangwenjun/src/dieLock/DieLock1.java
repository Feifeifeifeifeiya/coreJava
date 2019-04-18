package dieLock;

public class DieLock1 {

    private final Object lock=new Object();

    public DieLock1() {
    }

    private DieLock2 dieLock2;

    public void setDieLock2(DieLock2 dieLock2) {
        this.dieLock2 = dieLock2;
    }

    public void m1(){
        synchronized (lock){
            dieLock2.d1();
        }
    }

    public void m2(){
        synchronized (lock){
            System.out.println("m2--");
        }
    }
}
