package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CountDownLatchDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/7 0007 3:39
 * @Version 1.0
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t国灭亡了");
                countDownLatch.countDown();
            },CountryEnum.forEach_CuntryEnum(i).getCountryName()).start();
        }
        try {
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("秦国一统华夏");


    }
}

enum CountryEnum{
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");

    private Integer retCode;
    private String countryName;

    public Integer getRetCode() {
        return retCode;
    }

    public String getCountryName() {
        return countryName;
    }

    CountryEnum(Integer retCode, String countryName) {
        this.retCode = retCode;
        this.countryName = countryName;
    }

    public static CountryEnum forEach_CuntryEnum(int i){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum country:values){
            if(i == country.getRetCode()){
                return country;
            }
        }
        return null;
    }
}