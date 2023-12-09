package model;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private Money money;
    private List<Document> documents;

    public Wallet() {
        this.money = new Money();
        this.documents = new ArrayList<>();
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
