package model;

public class Wallet {
    private double sold;

    public Wallet() {
        this.sold = 0;
    }

    public Wallet(double sold) {
        this.sold = sold;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }
}
