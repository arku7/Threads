package com.task;

public class Gate {
    private long waiting;
    private int number;
    private long addWaiting;
    private int load;

    public Gate(long waiting, int number, long addWaiting, int load) {
        this.number = number;
        this.waiting = waiting;
        this.addWaiting = addWaiting;
        this.load = load;
    }

    public long getAddWaiting() { return addWaiting; }

    public int getLoad() { return load; }

    public int getNumber() { return number; }

    public long getWaiting() { return waiting; }

}
