import { Wallet } from "../model/wallet.model";
import { myPrompt } from "../util/my.prompt.util";

export const printWallet = (wallet: Wallet): void => {
  console.log(`Wallet: \n - sold: ${wallet.getSold()}`);
}

export const deposit = async (wallet: Wallet) => {
  const input = await myPrompt("Money to deposit: ");
  if (!isNaN(Number(input))) {
    wallet.setSold(wallet.getSold() + Number(input));
    return Promise.resolve("Deposit successfully");
  } else {
    return Promise.reject(new Error("Invalid Input - retry"));
  }
}

export const withdrawal = async (wallet: Wallet) => {
  const input = await myPrompt("Amount to withdraw: ");
  if (!isNaN(Number(input))) {
    const amount = Number(input);
    if (amount > wallet.getSold()) {
      return Promise.reject(new Error("Insufficient balance"));
    } else {
      wallet.setSold(wallet.getSold() - amount);
      return Promise.resolve("Withdrawal successfully");
    }
  } else {
    return Promise.reject(new Error("Invalid Input - retry"));
  }
}