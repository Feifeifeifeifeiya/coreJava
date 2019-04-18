package com.example.testjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 23:01
 * @Version 1.0
 **/
public class Person {
    @SerializedName("NAME")
    private String name;
    @Expose(serialize = false)
    private int age;
    @Expose(serialize = false)
    private Date birthday;
    private String school;
    private List major;
    private boolean hasGirlFriend;
    private boolean car;
    private boolean house;
    private String comment;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", school='" + school + '\'' +
                ", major=" + major +
                ", hasGirlFriend=" + hasGirlFriend +
                ", car=" + car +
                ", house=" + house +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List getMajor() {
        return major;
    }

    public void setMajor(List major) {
        this.major = major;
    }

    public boolean isHasGirlFriend() {
        return hasGirlFriend;
    }

    public void setHasGirlFriend(boolean hasGirlFriend) {
        this.hasGirlFriend = hasGirlFriend;
    }

    public boolean isCar() {
        return car;
    }

    public void setCar(boolean car) {
        this.car = car;
    }

    public boolean isHouse() {
        return house;
    }

    public void setHouse(boolean house) {
        this.house = house;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
