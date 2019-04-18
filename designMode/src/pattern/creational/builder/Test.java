package pattern.creational.builder;

public class Test {
    public static void main(String[] args) {
        CourseBuilder courseBilder = new JavaCourseBilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBilder);
        Course course = coach.builderCourse("Java设计模式精讲", "老师的PPT很low", "老师的Video还可以", "没有笔记", "互动互动");
        System.out.println(course);
    }
}
