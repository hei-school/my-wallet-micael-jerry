package model;

import java.time.Instant;

public class History {
    private Instant timestamp;
    private OperationType operation;
    private Wallet wallet;


    public History(OperationType operation, Wallet wallet) {
        this.timestamp = Instant.now();
        this.operation = operation;
        this.wallet = wallet;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
