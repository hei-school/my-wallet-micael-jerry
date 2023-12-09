import { Money } from "../model/money.model";
import { myPrompt } from "../util/my.prompt.util";

export const printMoney = (money: Money): void => {
  console.log(`Money: \n - sold: ${money.getSold()}`);
}

export const deposit = async (money: Money) => {
  const input = await myPrompt("Money to deposit: ");
  if (!isNaN(Number(input))) {
    money.setSold(money.getSold() + Number(input));
    return Promise.resolve("Deposit successfully");
  } else {
    return Promise.reject(new Error("Invalid Input - retry"));
  }
}

export const withdrawal = async (money: Money) => {
  const input = await myPrompt("Amount to withdraw: ");
  if (!isNaN(Number(input))) {
    const amount = Number(input);
    if (amount > money.getSold()) {
      return Promise.reject(new Error("Insufficient balance"));
    } else {
      money.setSold(money.getSold() - amount);
      return Promise.resolve("Withdrawal successfully");
    }
  } else {
    return Promise.reject(new Error("Invalid Input - retry"));
  }
}