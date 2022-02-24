package com.company;

import com.task.*;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Gate gate1 = new Gate(20, 1, 0, 3);
        Gate gate2 = new Gate(20, 2, 0, 5);
        Gate gate3 = new Gate(50, 3, 10, 15);
        Weight weight = new Weight(186);

        loadThread thread1 = new loadThread(gate1, weight);
        loadThread thread2 = new loadThread(gate2, weight);
        loadThread thread3 = new loadThread(gate3, weight);

        long startTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        System.out.println("Time spent : " + resultTime/10 + " minutes");
        System.out.println("Gates 1 loaded : " + thread1.getCargoLoaded());
        System.out.println("Gates 2 loaded : " + thread2.getCargoLoaded());
        System.out.println("Gates 3 loaded : " + thread3.getCargoLoaded());

    }
}
