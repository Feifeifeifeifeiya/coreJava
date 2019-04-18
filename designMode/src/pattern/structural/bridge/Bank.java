package pattern.structural.bridge;

/**
 * @ClassName Bank
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 19:29
 * @Version 1.0
 **/
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

      abstract  Account openAccount();
}
