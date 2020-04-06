package server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int i = 0;

        try {
            while (i < 100) {

                ThreadReadFood threadReadFood = new ThreadReadFood();
                ThreadReadAddress threadReadAddress = new ThreadReadAddress();

                executorService.execute(threadReadFood);
                Thread.sleep(1000);
                executorService.execute(threadReadAddress);
                Thread.sleep(1000);

                i++;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
