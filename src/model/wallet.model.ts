import { Money } from "./money.model";

export class Wallet {
  money: Money

  constructor () {
    this.money = new Money(0);
  }

  getMoney () {
    return this.money;
  }

  setMoney (money: Money) {
    this.money = money;
  }
}