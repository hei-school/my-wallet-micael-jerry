import { OperationType } from "./operation.type";
import { Wallet } from "./wallet.model";

export class OperationHistory {
  timestamp: Date;
  operation: OperationType;
  wallet: Wallet;

  constructor(operation: OperationType, wallet: Wallet) {
    this.timestamp = new Date();
    this.operation = operation;
    this.wallet = wallet;
  }

  getTimestamp(): Date {
    return this.timestamp;
  }

  getOperation(): OperationType {
    return this.operation;
  }

  getWallet(): Wallet {
    return this.wallet;
  }

  setTimestamp(timestamp: Date): void {
    this.timestamp = timestamp;
  }

  setOperation(operation: OperationType): void {
    this.operation = operation;
  }

  setWallet(wallet: Wallet): void {
    this.wallet = wallet;
  }
}