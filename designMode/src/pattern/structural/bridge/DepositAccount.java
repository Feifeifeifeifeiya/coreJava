package pattern.structural.bridge;

/**
 * @ClassName DepositAccount
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 19:24
 * @Version 1.0
 **/

/**定期账号
 */
public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
