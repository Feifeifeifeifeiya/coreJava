package pattern.structural.composite;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 16:29
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        CourseCatalog imooc = new CourseCatalog("慕课网目录", 1);
        Course course1 = new Course("linux课程", 10);
        Course course2 = new Course("windows课程", 10);

        CourseCatalog myCourse = new CourseCatalog("我的课程", 2);
        Course myCourse1 = new Course("电商1期", 30);
        Course myCourse2 = new Course("电商2期", 60);
        Course myCourse3 = new Course("电商3期", 90);
        myCourse.add(myCourse1);
        myCourse.add(myCourse2);
        myCourse.add(myCourse3);
        imooc.add(course1);
        imooc.add(course2);
        imooc.add(myCourse);
        imooc.print();
    }
}
