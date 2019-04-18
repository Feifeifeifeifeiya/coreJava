package pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 14:09
 * @Version 1.0
 **/
public class Teacher implements Observer {
    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {

        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    //现在这个方法是同步的，如果并发过高，需要使用消息队列或者其他的异步手段将他改为异步的，这个非常重要
    @Override
    public void update(Observable o, Object arg) {
        //o是被观察的对象
        Course course=(Course)o;
        Question question=(Question) arg;
        System.out.println(teacherName+"老师的"+course.getCourseName()+"课程接收到一个"+
                question.getUserName()+"提交的问答"+question.getQuestionContent());
    }
}
