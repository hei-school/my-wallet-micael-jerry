import { OperationHistory } from "./model/operation.history.model";
import { OperationType } from "./model/operation.type";
import { Wallet } from "./model/wallet.model";
import { deposit, printWallet, withdrawal } from "./service/wallet.service";
import { myPrompt } from "./util/my.prompt.util";
import { printHistory } from "./view/HistoryView";
import { printMenu } from "./view/MenuView";

export const run = (): void => {
  let wallet: Wallet = new Wallet(0);
  let historyList: OperationHistory[] = [];

  console.log("Welcome");

  let conditionRunning: boolean = true;
  while (conditionRunning) {
    printMenu("Status", "Deposit", "Withdraw", "History", "Exit");
    let choice: number = Number(myPrompt("Choice: "));
    while (!choice) {
      choice = Number(myPrompt("Please enter a valid number"));
    }
    switch (choice) {
      case 1:
        printWallet(wallet);
        historyList.push(
          new OperationHistory(
            OperationType.STATUS,
            new Wallet(wallet.getSold())
          )
        );
        break;
      case 2:
        deposit(wallet);
        historyList.push(
          new OperationHistory(
            OperationType.DEPOSIT,
            new Wallet(wallet.getSold())
          )
        );
        break;
      case 3:
        withdrawal(wallet);
        historyList.push(
          new OperationHistory(
            OperationType.WITHDRAW,
            new Wallet(wallet.getSold())
          )
        );
        break;
      case 4:
        printHistory(historyList);
        break;
      case 5:
        conditionRunning = false;
        console.log("Bye");
        break;
      default:
        console.log("RETRY");
    }
  }
};
