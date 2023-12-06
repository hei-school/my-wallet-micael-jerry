import { Wallet } from "../model/wallet.model";
import { myPrompt } from "../util/my.prompt.util";

export const printWallet = (wallet: Wallet): void => {
  console.log(`Wallet: \n - sold: ${wallet.getSold()}`);
}

export const deposit = (wallet: Wallet): void => {
  const input = myPrompt("Money to deposit: ");
  if (!isNaN(Number(input))) {
    wallet.setSold(wallet.getSold() + Number(input));
    console.log("Deposit successfully");
  } else {
    console.log("Invalid Input - retry");
  }
}

export const withdrawal = (wallet: Wallet): void => {
  const input = myPrompt("Amount to withdraw: ");
  if (!isNaN(Number(input))) {
    const amount = Number(input);
    if (amount > wallet.getSold()) {
      console.log("Insufficient balance");
    } else {
      wallet.setSold(wallet.getSold() - amount);
      console.log("Withdrawal successfully");
    }
  } else {
    console.log("Invalid Input - retry");
  }
}