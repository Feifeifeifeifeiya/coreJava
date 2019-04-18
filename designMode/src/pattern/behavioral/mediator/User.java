package pattern.behavioral.mediator;

/**
 * @ClassName User
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:53
 * @Version 1.0
 **/
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        StudyGroup.showMessage(this,message);
    }
}
