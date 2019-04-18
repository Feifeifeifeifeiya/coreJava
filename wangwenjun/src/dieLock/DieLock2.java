package dieLock;

public class DieLock2 {

    private final Object lock=new Object();

    private DieLock1 dieLock1;

    public DieLock2() {
    }

    public DieLock2(DieLock1 dieLock1) {
        this.dieLock1 = dieLock1;
    }

    public void setDieLock1(DieLock1 dieLock1) {
        this.dieLock1 = dieLock1;
    }

    public void d1(){
        synchronized (lock){
            System.out.println("d1-");
        }
    }

    public void d2(){
        synchronized (lock){
            dieLock1.m2();
        }
    }
}
