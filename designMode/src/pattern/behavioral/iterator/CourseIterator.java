package pattern.behavioral.iterator;

/**
 * @ClassName CourseIterator
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 1:48
 * @Version 1.0
 **/
public interface CourseIterator {
    Course nextCourse();

    boolean isLastCourse();
}
