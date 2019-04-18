package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName SimpleStreams
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 17:54
 * @Version 1.0
 **/
public class SimpleStreams {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("prok", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french", true, 500, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.FISH),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salon", false, 450, Dish.Type.MEAT)
        );
//        List<String> nameList = getDishNameBycollections(menu);
//        System.out.println(nameList);
        System.out.println("=====================================================");
        System.out.println(getDishNameByStream(menu));
    }

    //streams的方式
    private static List<String> getDishNameByStream(List<Dish> dishList ){
       return dishList.stream().filter(dish ->{
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           return   dish.getCalories()<400;
       })
                .sorted(Comparator.comparing((dish)->dish.getCalories()))
                .map(Dish::getName).collect(toList());

    }

    private static List<String> getDishNameBycollections(List<Dish> dishList){
        ArrayList<Dish> dishes = new ArrayList<>();
        //把卡路里低于400的名字列出来
        for(Dish dish:dishList){
            if(dish.getCalories()<400){
                dishes.add(dish);
            }
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dishes.sort((o1,o2)->Integer.compare(o1.getCalories(),o2.getCalories()));
        ArrayList<String> nameList = new ArrayList<>();
        for(Dish dish:dishes){
            nameList.add(dish.getName());
        }
        return nameList;
    }
}
