import java.lang.reflect.Method;

public class TestCaseRun {
    public static void main(String args[]){
       Class clazz=TestCase.class;
        Method[] methods = clazz.getMethods();
        for(Method m:methods){
            if(m.isAnnotationPresent(Test.class)){
                try{
                    m.invoke(new TestCase());

                }catch (Exception e){
                   e.printStackTrace();
                }
            }
        }
    }
}
