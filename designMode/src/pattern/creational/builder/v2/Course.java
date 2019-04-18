package pattern.creational.builder.v2;

public class Course {

    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    private String courseQA;

    public Course(CourseBuilder courseBuilder){
        this.courseName=courseBuilder.courseName;
        this.coursePPT=courseBuilder.courseArticle;
        this.courseVideo=courseBuilder.courseVideo;
        this.courseArticle=courseBuilder.courseArticle;
        this.courseQA=courseBuilder.courseQA;
    }

    public static class CourseBuilder{
        private String courseName;
        private String coursePPT;
        private String courseVideo;
        private String courseArticle;
        private String courseQA;
        //进行builder，返回的是自身，可以进行链式调用
        public CourseBuilder builderCourseName(String courseName){
            this.courseName=courseName;
            return this;
        }

        @Override
        public String toString() {
            return "CourseBuilder{" +
                    "courseName='" + courseName + '\'' +
                    ", coursePPT='" + coursePPT + '\'' +
                    ", courseVideo='" + courseVideo + '\'' +
                    ", courseArticle='" + courseArticle + '\'' +
                    ", courseQA='" + courseQA + '\'' +
                    '}';
        }

        public CourseBuilder builderCoursePPT(String coursePPT){
            this.coursePPT=coursePPT;
            return this;
        }
        public CourseBuilder builderCourseVideo(String courseVideo){
            this.courseVideo=courseVideo;
            return this;
        }
        public CourseBuilder builderCourseArticle(String courseArticle){
            this.courseArticle=courseArticle;
            return this;
        }
        public CourseBuilder builderCourseQA(String courseQA){
            this.courseQA=courseQA;
            return this;
        }
        public Course builderCourse(){
            return new Course(this);
        }
    }
}
