import java.io.*;

/**
 * @ClassName ObjectStreamTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/15 0015 23:01
 * @Version 1.0
 **/
public class ObjectStreamTest {
//    public static void main(String[] args) throws IOException {
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:person.object"));
//        Person person = new Person();
//        person.setName("李绘");
//        person.setAge(30);
//        objectOutputStream.writeObject(person);
//        objectOutputStream.close();
//    }
      public static void main(String[] args) throws IOException, ClassNotFoundException {
          ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:\\person.object"));
          Person o = (Person)objectInputStream.readObject();
          System.out.println(o);
      }
}
