package pattern.behavioral.observer;

import java.util.Observable;

/**
 * @ClassName Course
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 14:07
 * @Version 1.0
 **/
public class Course extends Observable {
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void produceQuestion(Course course,Question question){
        System.out.println(question.getUserName()+"在"+course.courseName+"下提了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
