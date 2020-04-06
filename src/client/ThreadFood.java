package client;

import java.io.FileWriter;
import java.io.IOException;

public class ThreadFood implements Runnable {
    private Food food;

    public ThreadFood(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        saveFoodToFile(food);
    }

    private static void saveFoodToFile(Food foods) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\IPComp\\IdeaProjects\\Task1Day8\\src\\client\\Food.txt");
            fw.write(foods.getNameFood());
            fw.close();
        } catch (IOException e) {
            System.out.println("Failed Add Address Data");
        }

        System.out.println("Write Food " + foods.getNameFood());
    }
}

