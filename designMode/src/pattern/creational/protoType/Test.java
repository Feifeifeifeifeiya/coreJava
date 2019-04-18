package pattern.creational.protoType;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        for(int i=0;i<10;i++){
            Mail mailtemp= (Mail) mail.clone();
            mailtemp.setName("姓名："+i);
            mailtemp.setEmailAddress("姓名"+i+"@Imooc.com");
            mailtemp.setContent("恭喜你，慕课网活动中奖了");
            MailUtil.sendMail(mailtemp);
        }
        MailUtil.saveOriginMail(mail);
    }
}
