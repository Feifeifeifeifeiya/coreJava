package openclose;

public class Test {

    public static void main(String[] args) {
        JavaCourse hahah = new JavaDisCountCourse(12, "hahah", 256);
        JavaDisCountCourse javaDis=(JavaDisCountCourse)hahah;
        System.out.println(javaDis.getId()+javaDis.getName()+javaDis.getPrice()+javaDis.getOldPrice());
    }
}
