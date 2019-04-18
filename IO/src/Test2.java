import java.io.UnsupportedEncodingException;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 1:36
 * @Version 1.0
 **/
public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
     //按照字节长度截取字符串
        String s="ab你好cd谢谢";
        int len=s.getBytes("GBK").length;
        for(int x=0;x<len;x++){
            System.out.println(custStringByByte(s,x+1));
        }
    }


    public static String custStringByByte(String string,int len) throws UnsupportedEncodingException {
        byte[] bytes = string.getBytes("gbk");
        int count = 0;
        for (int x=len-1;x>=0;x--){
            if(bytes[x]<0){
                count++;
            }else{
                break;
            }
        }
        if(count%2==0){
            return new String(bytes,0,len,"GBK");
        }else{
            return new String(bytes,0,len-1,"GBk");
        }
    }
}
