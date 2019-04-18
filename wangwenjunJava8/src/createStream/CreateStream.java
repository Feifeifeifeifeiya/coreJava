package createStream;


import javafx.beans.binding.ObjectExpression;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @ClassName CreateStream
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 20:41
 * @Version 1.0
 **/
public class CreateStream {
    public static void main(String[] args) throws IOException{
        createStramFromConllections().forEach(System.out::println);
        System.out.println("==========================================");
        createSteamFomValues().forEach(System.out::println);
        System.out.println("==========================================");
        createSteamFomArrays().forEach(System.out::println);
        System.out.println("==========================================");
        createStreamFromFile().forEach(System.out::println);
        System.out.println("==========================================");
        createStreamFromIterator().forEach(System.out::println);
        System.out.println("==========================================");
        createStreamFromgenerate().forEach(System.out::println);
        System.out.println("==========================================");
        createStreamFromObj().forEach(System.out::println);
    }

    public static Stream<String> createStramFromConllections(){
        List<String> stringList = Arrays.asList("hello", "elex", "wufei", "world");
        return stringList.stream();
    }

    public static Stream<String> createSteamFomValues(){
        return Stream.of("hello", "elex", "wufei", "world");
    }

    public static Stream<String> createSteamFomArrays(){
        String[] strings={"hello", "elex", "wufei", "world"};
        return Arrays.stream(strings);
    }

    public static Stream<String> createStreamFromFile() throws IOException {
        Path path = Paths.get("C:\\Users\\Administrator\\Desktop\\cryptoDemo\\SampleCode\\SampleCode\\Java\\readme.txt");
        Charset gbk = Charset.forName("GBK");
        Stream<String> lines = Files.lines(path,gbk);
        return lines;
    }

    public static Stream<Integer> createStreamFromIterator(){
        return Stream.iterate(0,n->n+2).limit(10);
    }

    public static Stream<Double> createStreamFromgenerate(){
        return Stream.generate(Math::random).limit(10);
    }

    public static Stream<Obj> createStreamFromObj(){
        return Stream.generate(new ObjSupplier<>());
    }

   static class Obj{
        private int id;
        private String name;

        @Override
        public String toString() {
            return "Obj{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {

            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


 }
}
 class ObjSupplier<Obj> implements Supplier<Obj>{
    private int index=0;
    private Random random=new Random(System.currentTimeMillis());
    @Override
    public Obj get() {
        index=random.nextInt(100);

        return (Obj) new CreateStream.Obj(index,"name->"+index);
    }
}