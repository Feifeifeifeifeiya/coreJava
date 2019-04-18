@Persion(name = "lisi",age = 24,hobby = {"test1","test2"})
public class Student {
    @StudentGender(gender = StudentGender.Gender.BOY)
    private String stuGender;

    @Override
    public String toString() {
        return "Student{" +
                "stuGender='" + stuGender + '\'' +
                '}';
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }
}
