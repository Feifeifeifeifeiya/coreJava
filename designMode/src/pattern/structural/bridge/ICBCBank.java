package pattern.structural.bridge;

/**
 * @ClassName ICBCBank
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 19:36
 * @Version 1.0
 **/
public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国工商银行账号");
        account.openAccount();
        return account;
    }
}
