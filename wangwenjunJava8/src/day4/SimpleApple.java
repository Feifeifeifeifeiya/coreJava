package day4;

/**
 * @ClassName SimpleApple
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 17:36
 * @Version 1.0
 **/
public class SimpleApple {
    private String color;
    private Long weight;
    private String disposition;

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

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public SimpleApple(String color, Long weight, String disposition) {

        this.color = color;
        this.weight = weight;
        this.disposition = disposition;
    }
}
