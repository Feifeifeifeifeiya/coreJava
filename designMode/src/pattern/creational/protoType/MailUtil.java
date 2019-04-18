package pattern.creational.protoType;

import java.text.MessageFormat;

public class MailUtil {

    public static void sendMail(Mail mail){
        String outputContent="向{0}同学，邮件地址：{1},邮件内容:{2}发送邮件成功";
        System.out.println(MessageFormat.format(outputContent,mail.getName(),mail.getEmailAddress(),mail.getContent()));
    }

    //保存邮件原始记录
    public static void saveOriginMail(Mail mail){
        System.out.println("保存OriginMail记录，Origin："+mail.getContent());
    }
}
