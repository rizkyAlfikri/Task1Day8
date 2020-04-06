package client;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            System.out.println("Failed Add Order Data");
        }

        System.out.println("Write Food " + foods.getNameFood());
    }

    private static List<Food> readFoodFromFile() {
        List<Food> foodList = new ArrayList<Food>();


        try {
            FileReader fr = new FileReader("C:\\Users\\IPComp\\IdeaProjects\\Task1Day8\\src\\client\\Food.txt");
            int byteStream;
            StringBuilder dataBuffer = new StringBuilder();
            while ((byteStream = fr.read()) != -1) {
                dataBuffer.append((char) byteStream);
            }

            List<String> arrayBuffer = new ArrayList<String>(Arrays.asList(dataBuffer.toString().split(",")));
            for (String str : arrayBuffer) {
                foodList.add(new Food(str));
            }


        } catch (
                IOException e) {
            System.out.println("Failed Read Order Data");
        }
        return foodList;
    }
}

