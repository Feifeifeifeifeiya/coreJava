public class Circle {

    private double redius=0;
    public static int count=1;
    public Circle(double redius) {
        this.redius = redius;
        getDraw().drawShape();
    }

    public Circle(){

    }

    private Draw getDraw(){
        return new Draw();
    }
    class Draw{   //内部类
        public void drawShape(){
            System.out.println(redius);
            System.out.println(count);
        }
    }

    public double getRedius() {
        return redius;
    }

    public void setRedius(double redius) {
        this.redius = redius;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Circle.count = count;
    }
}


