package server;

import client.Food;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadReadFood implements Runnable {


    @Override
    public void run() {
        List<Food> foodList = new ArrayList<Food>(readFoodFromFile());


            System.out.println("Read Food = " + foodList.get(0).getNameFood());


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
