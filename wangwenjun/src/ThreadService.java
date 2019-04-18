public class ThreadService {

    private Thread excuteThread;

    private boolean finished=false;

    public void excute(Runnable task){
        excuteThread=new Thread(){
            @Override
            public void run(){
                Thread thread = new Thread(task);
                thread.setDaemon(true);
                thread.start();
                try {
                    thread.join();
                    finished=true;
                } catch (InterruptedException e) {
                }

            }
        };
        excuteThread.start();
    }

    public void shutDown(long millis){
        long timeMillis = System.currentTimeMillis();
        while (!finished){
            if((System.currentTimeMillis()-timeMillis)>millis){
                System.out.println("任务超时，需要结束他");
                excuteThread.interrupt();
                break;
            }
            try {
                excuteThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("线程被中断");
                break;
            }
        }
        finished=false;
    }

    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.excute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadService.shutDown(10000);
       long end= System.currentTimeMillis();
        System.out.println(end-start);
    }
}
