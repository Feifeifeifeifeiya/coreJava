package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FilterApple
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 0022 23:37
 * @Version 1.0
 **/
public class FilterApple {

     public   interface filterStrategy{
        boolean filter(Apple apple);
    }

    public static class GreenAnd150Weightfiltor implements filterStrategy{
        @Override
        public boolean filter(Apple apple) {
            if("green".equals(apple.getColor())&& 150L<apple.getWeight()){
                return true;
            }
            return false;
        }
    }


    public List<Apple> findGreenApple(List<Apple> apples,filterStrategy filterStrategy){
        List<Apple> appleList = new ArrayList<>();
        for(Apple apple:apples){
            if(filterStrategy.filter(apple)){
                appleList.add(apple);
            }
        }
        return appleList;
    }


//    public static void main(String[] args) {
//        List<Apple> apples=Arrays.asList(new Apple("green",160L),new Apple("red",120L),new Apple("green",110L));
//        FilterApple filterApple = new FilterApple();
//        List<Apple> greenApple = filterApple.findGreenApple(apples, new filterStrategy() {
//            @Override
//            public boolean filter(Apple apple) {
//                if("green".equals(apple.getColor())&& 150L<apple.getWeight()){
//                    return true;
//                }
//                return false;
//            }
//        });
//        assert greenApple.size()==1 : "错了";
//        System.out.println(greenApple);
//    }

//    public static void main(String[] args) {
//        List<Apple> apples=Arrays.asList(new Apple("green",160L),new Apple("red",120L),new Apple("green",110L));
//        FilterApple filterApple = new FilterApple();
//        List<Apple> green = filterApple.findGreenApple(apples, (apple) -> {
//            return apple.getColor().equals("green");
//        });
//        System.out.println(green);
//        }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
    }

