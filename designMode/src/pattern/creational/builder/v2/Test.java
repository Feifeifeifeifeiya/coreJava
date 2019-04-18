package pattern.creational.builder.v2;

public class Test {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().builderCourseName("java设计模式精讲").builderCoursePPT("没有PPT").builderCourseVideo("Video还可以").builderCourseArticle("没有笔记").builderCourseQA("互动互动").builderCourse();
        System.out.println(course);
    }
}
