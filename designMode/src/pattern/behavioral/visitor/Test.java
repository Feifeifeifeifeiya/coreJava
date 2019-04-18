package pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.L;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:53
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("SpringMVC数据绑定");
        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("java设计模式精讲");
        codingCourse.setPrice(200.0);
        courses.add(freeCourse);
        courses.add(codingCourse);
        for(Course course:courses){
            course.accept(new Visitor());
        }

    }
}
