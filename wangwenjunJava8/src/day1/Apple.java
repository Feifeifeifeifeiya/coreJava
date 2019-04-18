package day1;

/**
 * @ClassName Apple
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 0022 23:33
 * @Version 1.0
 **/
public class Apple {
    private String color;
    private Long weight;

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Apple(String color, Long weight) {

        this.color = color;
        this.weight = weight;
    }
}
