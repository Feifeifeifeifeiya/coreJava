package pattern.structural.flyWeight;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 14:57
 * @Version 1.0
 **/
public class Test {
    private static final String departments[]={"RD","QA","PM","BD"};

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            String department= departments[(int)(Math.random()*departments.length)];
            Manager manager = EmployeeFactory.getEmployee(department);
            manager.report();
        }
    }
}
