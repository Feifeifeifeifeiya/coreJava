package yinhang;

public class TryConcurrency {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread t1 = new Thread(bank, "一号柜台");
        Thread t2 = new Thread(bank, "二号柜台");
        Thread t3 = new Thread(bank, "三号柜台");
        t1.start();
        t2.start();
        t3.start();

    }
}
