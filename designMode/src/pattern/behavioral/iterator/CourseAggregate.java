package pattern.behavioral.iterator;

/**
 * @ClassName CourseAggregate
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 1:47
 * @Version 1.0
 **/
public interface CourseAggregate {

    void addCourse(Course course);

    void removeCourse(Course course);

    CourseIterator getCourseIterator();
}
