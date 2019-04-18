package pattern.creational.protoType.clone;

import java.util.Date;

public class Pig implements Cloneable {

    private String name;
    private Date birthday;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}'+super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pig pig = (Pig) super.clone();
        //进行深度克隆
        pig.birthday= (Date) pig.getBirthday().clone();
        return pig;
    }
}
