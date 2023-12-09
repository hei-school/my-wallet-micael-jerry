package model;

public class Wallet {
    private Money money;

    public Wallet() {
        this.money = new Money();
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
