//模拟先从数据库查取，在往文件中写入
public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                readFromDataBase();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                writeToFile();
            }
        }.start();
    }

    //模拟读取数据库
    private static void readFromDataBase(){
        try {
            print("正在开始读取数据库。。。");
            Thread.sleep(10000);
            print("正在读取数据库");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("读取数据库操作已完成");
    }

    //模拟写入文件
    private static void writeToFile(){
        try {
            print("正在开始写入文件。。。");
            Thread.sleep(10000);
            print("正在写入文件");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("写入文件操作操作已完成");
    }

    private static void print(String message){
        System.out.println(message);
    }
}
