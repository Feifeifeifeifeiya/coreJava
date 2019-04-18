public class ProduceAndConsumer {

    private int i=0;

    private volatile boolean flag=false;

    public void produce(){
        synchronized (this){
            if(flag){
                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                i++;
                System.out.println("p->"+i);
                flag=true;
//                this.notifyAll();
            }
        }
    }

    public void consumer(){
        synchronized (this){
            if(flag){
                i--;
                System.out.println("c->"+i);
//                this.notifyAll();
                flag=false;
            }else{
                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceAndConsumer produceAndConsumer = new ProduceAndConsumer();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        produceAndConsumer.produce();
                }
            }).start();
        }
        ;
        for (int j = 0; j < 2; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        produceAndConsumer.consumer();
                }
            }).start();
        }
    }
}
