package pattern.behavioral.iterator;

import java.util.List;

/**
 * @ClassName CourseIteratorImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 1:53
 * @Version 1.0
 **/
public class CourseIteratorImpl implements CourseIterator {
    private List courseList;
    private int position;
    private Course course;

    public CourseIteratorImpl(List courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        System.out.println("返回课程,位置是"+position);
        course=(Course)courseList.get(position);
        position++;
        return course;
    }

    @Override
    public boolean isLastCourse() {
        if(position<courseList.size()){
            return false;
        }
        return true;
    }
}
