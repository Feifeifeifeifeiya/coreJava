package pattern.structural.bridge;

/**
 * @ClassName SavingAccount
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 19:25
 * @Version 1.0
 **/
/**
 活期账号
 **/
public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
