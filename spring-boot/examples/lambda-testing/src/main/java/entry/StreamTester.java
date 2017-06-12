package entry;

import model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wanggang on 10/26/16.
 */
public class StreamTester {

    private final static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 800, Dish.Type.FISH)
    );


    public static void main(String[] args) {

        String[] hel = {"hello", "world"};
        System.out.println(Arrays.stream(hel)
                .map( w -> w.split(" ")));

        List<String> threeHighCaloricDishNames =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<Integer[]> numbers3 = numbers1.stream()
                .flatMap(i -> numbers2
                                .stream()
                                .map(j -> new Integer[] {i, j}))
                .collect(Collectors.toList());

        System.out.println(numbers3);

        numbers3 = numbers1.stream()
                .flatMap(i -> numbers2
                        .stream()
                        .map(j -> new Integer[] {i, j}))
                .filter(l -> Arrays.stream(l).mapToInt(a -> a).sum() % 3 == 0)
                .collect(Collectors.toList());

        System.out.println(numbers3);

        numbers3 = numbers1.stream()
                .flatMap(i -> numbers2
                        .stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new Integer[] {i, j}))
                .collect(Collectors.toList());

        System.out.println(numbers3);

    }

}
