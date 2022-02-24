package com.task;

import static java.lang.Math.min;

public class loadThread extends Thread{
    int cargoLoaded = 0;
    int carLoaded = 0;
    Gate curGate;
    Weight weight;

    public loadThread(Gate curGate, Weight weight) {
        this.curGate = curGate;
        this.weight = weight;
    }

    public int getCargoLoaded() { return cargoLoaded; }

    public void run() {
        while(weight.getVal() > 0) {
            int lastWeight = weight.getVal();
            weight.setVal(weight.getVal() - min(lastWeight, curGate.getLoad()));
            System.out.println("Loading gates number " + curGate.getNumber() +
                "\n" + "Was : " + lastWeight +
                "\n" + "Left : " + weight.getVal() + "\n");
            synchronized (curGate) {
                try {
                    cargoLoaded += min(lastWeight, curGate.getLoad());
                    this.sleep(curGate.getWaiting());
                    carLoaded++;
                    if(carLoaded % 10 == 0) this.sleep(curGate.getAddWaiting());
                } catch (InterruptedException e){
                    this.interrupt();
                }
            }
        }
    }
}
