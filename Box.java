package HW1_1;

import java.util.*;

public class Box<T> {

    private ArrayList<T> content = new ArrayList<>();

    public void addFruit(T fruit) {
        this.content.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T f : this.content) {
            weight += ((Fruit) f).getFruitWeight();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> b2) {
        return b2.getWeight() == this.getWeight();
    }

    public void fillOtherBox(Box<T> otherBox) {
        for (T f : this.content) {
            otherBox.addFruit(f);
        }
        this.content.clear();
    }
}