package pattern.behavioral.mediator;

import java.util.Date;

/**
 * @ClassName StudyGroup
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:54
 * @Version 1.0
 **/
public class StudyGroup {
    public static void showMessage(User user,String message){
        System.out.println(new Date().toString()+"["+user.getName()+"]"+message);
    }
}
