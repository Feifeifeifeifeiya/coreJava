package pattern.structural.bridge;

/**
 * @ClassName ABCBank
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 19:33
 * @Version 1.0
 **/
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
