package dynamicProxy;


public class Teacher implements Human{
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(name+"上班交班费50元");
    }
}
