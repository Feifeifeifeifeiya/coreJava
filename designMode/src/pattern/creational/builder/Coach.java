package pattern.creational.builder;

public class Coach {

    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course builderCourse(String courseName,String coursePPT,String courseVideo,String courseArticle,String courseQA){
        courseBuilder.builderCourseName(courseName);
        courseBuilder.builderCoursePPT(coursePPT);
        courseBuilder.builderCourseVideo(courseVideo);
        courseBuilder.builderCourseArticle(courseArticle);
        courseBuilder.builderCourseQA(courseQA);
        return courseBuilder.builderCourse();
    }
}
