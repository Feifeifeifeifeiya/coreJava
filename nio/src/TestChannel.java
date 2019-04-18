
import com.sun.org.apache.bcel.internal.generic.Select;
import jdk.nashorn.internal.ir.WhileNode;
import org.junit.Test;


import java.io.*;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


/**
 * 1.通道（channel）:用于源节点与目标节点的连接，在java NID中负责缓冲区中数据的传输。channel本身不存储数据，因此需要配合缓冲区进行传输
 * 2.通道的主要实现类：
 * java.nio.channels.Channel接口
 * FileChannel
 * SocketChannel
 * ServerSocketChannel
 * DatagramChannel
 *3.获取通道
 *  1.java针对支持通道的类提供了getChannel的方法
 *  本地IO：
 *    FileInputStream/FileoutputStream
 *    RandomAccessFile
 *
 *  网络IO：
 *  Socket
 *  ServerSocket
 *  DatagramSocket
 *  2.在JDK1.7中的NIO.2针对各个通道提供了静态方法open（）
 *  3.在JDK1.7中的NIO.2的Files工具类的newByteChannel方法
 *
 * 4.通道之间的数据传输
 * transferFrom（）
 * transferTo（）
 *
 * 5.分散（Scatter）与聚集（Gather）
 * 分散读取（Scatting Reads）:将通道里的数据分散到多个缓冲区中
 * 聚集写入(Gathring Writes):将多个缓冲区中的数据聚集到通道中
 *
 * 6.编码解码
 */

public class TestChannel {

    //获取管道
    @Test
    public void pipeTest() throws IOException {
        //获取管道
        Pipe pipe = Pipe.open();
        //将缓冲区写入管道
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sink = pipe.sink();
        byteBuffer.put("真帅".getBytes());
        byteBuffer.flip();
        sink.write(byteBuffer);

        //读取缓冲区的数据
        Pipe.SourceChannel source = pipe.source();
        byteBuffer.flip();
        int i = source.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(),0,i));

        sink.close();
        source.close();
    }

    //数据报形式
    @Test
    public void testDatagramClient() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();

        datagramChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String s = scanner.next();
            buffer.put((new Date().toString()+":\n"+s).getBytes());
            buffer.flip();
            datagramChannel.send(buffer,new InetSocketAddress("127.0.0.1",7777));
            buffer.clear();
        }
        datagramChannel.close();
    }

    @Test
    public void testDatagramServer() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();

        datagramChannel.configureBlocking(false);

        datagramChannel.bind(new InetSocketAddress(7777));

        Selector selector = Selector.open();

        datagramChannel.register(selector,SelectionKey.OP_READ);

        while (selector.select()>0){
            Iterator<SelectionKey> keys = selector.keys().iterator();

            while (keys.hasNext()){
                SelectionKey key = keys.next();
                if(key.isReadable()){
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    datagramChannel.receive(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
                    byteBuffer.clear();
                }
            }
            keys.remove();
        }
    }
    //7.非阻塞式IO
    @Test
    public void testClient() throws Exception{
        //网络获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        //切换成非阻塞模式
        sChannel.configureBlocking(false);
        //创建缓冲区
        ByteBuffer bufffer = ByteBuffer.allocate(1024);
        ByteBuffer buffer = bufffer.put((LocalDateTime.now().toString()+"好帅").getBytes());
        sChannel.write(buffer);
        //关闭通道
        sChannel.close();

    }

    @Test
    public void testServer() throws IOException {
        //网络获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //切换成非阻塞模式
        ssChannel.configureBlocking(false);
        //绑定端口号
        ssChannel.bind(new InetSocketAddress(9999));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器中,并且指定“监听接收事件”
        SelectionKey selectionKey = ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //轮询式获取选择器上已经"准备就绪的选择事件"
        while (selector.select()>0){
            //获取当前选择器中所有注册的选择键（已经就绪的选择事件）
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //获取准备就绪的事件
                SelectionKey key = iterator.next();
                //判断具体是什么事件准备就绪
                if(key.isAcceptable()){
                    //若连接就绪，获取客户端连接
                    SocketChannel socketChannel = ssChannel.accept();
                    //切换成非阻塞模式
                    socketChannel.configureBlocking(false);
                    //将该通道注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    //获取当前选择器上读就绪的通道
                }else if(key.isReadable()){
                    SocketChannel sChannel=(SocketChannel) key.channel();
                    //读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=sChannel.read(buffer))>0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                //取消选择键selectKey
                iterator.remove();
            }
        }
    }

    //6.阻塞式IO
    @Test
    public void clint() throws Exception{
        //1.网络获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //本地通道
        FileChannel fileChannel = FileChannel.open(Paths.get("126.jpg"), StandardOpenOption.READ);
        //2.分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //3.读取本地文件
        while (fileChannel.read(buffer)!=-1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.shutdownOutput();
        int len=0;
        while ((len=socketChannel.read(buffer)) != -1){
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            buffer.clear();
        }
        fileChannel.close();
        socketChannel.close();

    }
    @Test
    public void server() throws Exception{
        //1.获取网络通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        //获取本地通道（网络获取到的要写入本地）
        FileChannel fileChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW, StandardOpenOption.READ);
        //2.绑定连接
        socketChannel.bind(new InetSocketAddress(9898));
        //3.获取客户端连接的通道
        SocketChannel accept = socketChannel.accept();
        //4.分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //5.接收客户端的数据，并写入到本地
        while (accept.read(buffer)!=-1){
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }
        buffer.put("发送成功！".getBytes());
        buffer.flip();
        accept.write(buffer);
        accept.close();
        fileChannel.close();
        socketChannel.close();
    }

    //5.编码解码
    @Test
    public void test5() throws Exception{
        Charset ch1 = Charset.forName("utf-8");
        //编码
        CharsetEncoder encoder = ch1.newEncoder();
        //解码
        CharsetDecoder decoder = ch1.newDecoder();
        //创建缓冲区
        CharBuffer buffer = CharBuffer.allocate(1024);
        buffer.put("吴飞是真帅");
        //切换读模式
        buffer.flip();
        //进行编码
        ByteBuffer encode = encoder.encode(buffer);
        for (int i=0;i<12;i++){
            System.out.println(encode.get());
        }
        System.out.println("-----------------------------");
        //切换读模式
        buffer.flip();
        //进行解码
        CharBuffer decode = decoder.decode(encode);
        System.out.println(decode.toString());
        //换成jbk解码
        Charset gbk = Charset.forName("gbk");
        CharBuffer decode1 = gbk.decode(encode);
        System.out.println("====="+decode1.toString());

    }

    //4.分散和聚集
    @Test
    public void test4() throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("PropertiesListenerConfig.java","rw");

        //1.获取通道
        FileChannel channel1 = randomAccessFile.getChannel();

        //2.分配指定大小的字符
        ByteBuffer by1 = ByteBuffer.allocate(100);
        ByteBuffer by2 = ByteBuffer.allocate(1024);

        //3.分散读取
        ByteBuffer[] bys={by1,by2};
        channel1.read(bys);

        for (ByteBuffer byteBuffer:bys) {
            byteBuffer.flip();
        }

        System.out.println(new String(bys[0].array(),0,bys[0].limit()));
        System.out.println("=======================================");
        System.out.println(new String(bys[1].array(),0,bys[1].limit()));

        RandomAccessFile randomAccessFile1 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel = randomAccessFile1.getChannel();
        channel.write(bys);
    }

    //3.通道之间的数据传输
    @Test
    public void test3() throws IOException {
        long start = System.currentTimeMillis();
        //创建通道
        FileChannel inChannel = FileChannel.open(Paths.get("d:/eclipse.zip"), StandardOpenOption.READ);
        FileChannel putChannel = FileChannel.open(Paths.get("d:/haha.zip"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //传输数据
        //inChannel.transferTo(0,inChannel.size(),putChannel);
        putChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        putChannel.close();
        long end = System.currentTimeMillis();
        System.out.println("使用时间"+(end-start));
    }

    //2.使用直接缓冲区完成文件的复制（内存映射文件）
    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            //创建通道
            inChannel = FileChannel.open(Paths.get("d:/eclipse.zip"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("d:/haha.zip"),StandardOpenOption.WRITE,  StandardOpenOption.READ,StandardOpenOption.CREATE);
            //内存映射文件
            MappedByteBuffer inMapper = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMapper = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
            //直接对缓冲区的数据进行读写操作
            byte[] bytes = new byte[inMapper.limit()];
            inMapper.get(bytes);
            outMapper.put(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭管道
            try {
                if(inChannel!=null){
                    inChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(outChannel!=null){
                    outChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("使用时间"+(end-start));

    }

    //1.利用通道完成文件的复制
    @Test
    public void test1(){
        long start = System.currentTimeMillis();
        InputStream inputStream=null;
        OutputStream outputStream=null;
        FileChannel inputChannel=null;
        FileChannel outChannel=null;
        try {
            inputStream =  new FileInputStream("d:/eclipse.zip");
             outputStream = new FileOutputStream("d:/xixi.zip");
            //创建通道
            inputChannel = ((FileInputStream) inputStream).getChannel();
            outChannel =((FileOutputStream) outputStream).getChannel();
            //创建缓冲区对象
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
            while (inputChannel.read(byteBuffer)!=-1){
                //切换成读模式
                byteBuffer.flip();
                //将缓冲区的数据读取到通道中
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputChannel!=null){
                    inputChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outChannel!=null){
                    outChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("使用时间"+(end-start));
    }
}
