import { Document } from "./document";
import { Money } from "./money.model";

export class Wallet {
  private money: Money;
  private documents: Document[];

  constructor() {
    this.money = new Money(0);
    this.documents = [];
  }

  getMoney(): Money {
    return this.money;
  }

  getDocuments(): Document[] {
    return this.documents;
  }

  setMoney(money: Money) {
    this.money = money;
  }

  setDocuments(documents: Document[]): void {
    this.documents = documents;
  }
}
