package model;

public class Wallet {
    private String owner;
    private double sold;

    public Wallet() {
        this.owner = "anonymous";
        this.sold = 0;
    }

    public Wallet(String owner, double sold) {
        this.owner = owner;
        this.sold = sold;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }
}
