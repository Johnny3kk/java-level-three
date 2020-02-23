package HW1_1;

import java.util.*;

public class Main {

    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static  <T> List<T> exchangeIndexes(List<T> array, int i1, int i2) {
        List<T> a1 = new LinkedList<>(array);
        a1.set(i1, array.get(i2));
        a1.set(i2, array.get(i1));
        return a1;
    }

    //2.Написать метод, который преобразует массив в ArrayList;
    public static  <T> ArrayList<T> arrayToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args) {
// 1
        List<String> animals = new LinkedList<>();
        animals.add("beaver");
        animals.add("platypus");
        System.out.println(animals);
        System.out.println(exchangeIndexes(animals, 0, 1));

        List<Integer> ages = new LinkedList<>();
        ages.add(12);
        ages.add(63);
        System.out.println(ages);
        System.out.println(exchangeIndexes(ages, 0, 1));

// 2
        String[] arrayOfStrings = {"String1", "String2", "String3"};
        System.out.println(arrayToArrayList(arrayOfStrings));

// 3
        //First box with 3 apples
        Box<Apple> b1 = new Box<>();
        b1.addFruit(new Apple());
        b1.addFruit(new Apple());
        b1.addFruit(new Apple());

        //Second box with 4 apples
        Box<Apple> b2 = new Box<>();
        b2.addFruit(new Apple());
        b2.addFruit(new Apple());
        b2.addFruit(new Apple());
        b2.addFruit(new Apple());

        //Third box with 2 oranges
        Box<Orange> b3 = new Box<>();
        b3.addFruit(new Orange());
        b3.addFruit(new Orange());

        //Fourth empty Orange Box
        Box<Orange> b4 = new Box<>();

        System.out.println("Compare First and Second boxes");
        System.out.println(b1.compare(b2));

        System.out.println("Compare First and Third boxes (Orange and Apple)");
        System.out.println(b1.compare(b3));

        System.out.println("Fill from Third to Fourth box");
        b3.fillOtherBox(b4);
        //b1.fillOtherBox(b4); - mistake, can't fill orange box with apples
        System.out.println("Fourth box weight now:");
        System.out.println(b4.getWeight());
        System.out.println("And Third box should be empty:");
        System.out.println(b3.getWeight());

    }
}