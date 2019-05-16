/**
 * @ClassName Person
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/14 0014 21:29
 * @Version 1.0
 **/
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "I am a person, my name is " + name;
    }
}
