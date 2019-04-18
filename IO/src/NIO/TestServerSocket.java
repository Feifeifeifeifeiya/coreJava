package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @ClassName TestServerSocket
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/21 0021 20:58
 * @Version 1.0
 **/
public class TestServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //服务端切换成非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册在选择器上,并且指定“监听事件”,
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        //轮询式获取注册器上的已经“准备就绪”的事件
        while (selector.select()>0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            if(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                //如果是接收就绪
                if(selectionKey.isAcceptable()){
                    //获取客户端的连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //切换成非阻塞模式
                    socketChannel.configureBlocking(false);
                    //通道注册在选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    //获取当前选择器上的“读准备就绪”的通道
                    SocketChannel channel =(SocketChannel) selectionKey.channel();
                    //读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=channel.read(buffer))!=-1){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
            }
            //取消选择键，不取消，这个通道下次还是连接完成
            iterator.remove();
        }
    }
}
