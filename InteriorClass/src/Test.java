import java.sql.JDBCType;
import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        Bean1 bean1 = new Test().new Bean1();
        bean1.i++;
        Bean2 bean2 = new Bean2();
        bean2.j++;
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;
        System.out.println(bean1.i);
        System.out.println(bean2.j);
        System.out.println(bean3.k);
    }

    class Bean1{
        public int i=0;
    }
    static class Bean2{
        public int j=1;
    }
}

class Bean{
    class Bean3{
        public int k=0;
    }
}