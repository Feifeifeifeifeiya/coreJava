
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @ClassName PipedTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/15 0015 23:58
 * @Version 1.0
 **/
public class PipedTest {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedInputStream.connect(pipedOutputStream);
        Input input = new Input(pipedInputStream);
        Output output = new Output(pipedOutputStream);
        new Thread(input).start();
        new Thread(output).start();
    }


}
class Input implements Runnable{
    private PipedInputStream pipedInputStream;

    public Input(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            byte[] bytes = new byte[1024];
            int read = pipedInputStream.read(bytes);
            String string = new String(bytes,0,read);
            System.out.println("read"+string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Output implements Runnable{
    private PipedOutputStream pipedOutputStream;

    public Output(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try {
            pipedOutputStream.write("管道来了！！！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}