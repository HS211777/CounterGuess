package com.company;

public class Counter {
    private int colour; //1 = red, 2 = blue, 3 = yellow

    public Counter(int colour) {
        this.colour = colour;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}
