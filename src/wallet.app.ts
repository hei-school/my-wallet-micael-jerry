import { OperationHistory } from "./model/operation.history.model";
import { OperationType } from "./model/operation.type";
import { Wallet } from "./model/wallet.model";
import { deposit, printWallet, withdrawal } from "./service/wallet.service";
import { closeMyPrompt, myPrompt } from "./util/my.prompt.util";
import { bar } from "./view/bar.view";
import { printHistory } from "./view/history.view";
import { printMenu } from "./view/menu.view";

export const run = async () => {
  let wallet: Wallet = new Wallet(0);
  let historyList: OperationHistory[] = [];

  console.log("Welcome");

  let conditionRunning: boolean = true;
  while (conditionRunning) {
    printMenu("Status", "Deposit", "Withdraw", "History", "Exit");
    let input = await myPrompt("Choice: ");
    let choice: number = Number(input);
    while (!choice) {
      input = await myPrompt("Please enter a valid number");
    }
    switch (choice) {
      case 1:
        bar("Status")
        printWallet(wallet);
        historyList.push(
          new OperationHistory(
            OperationType.STATUS,
            new Wallet(wallet.getSold())
          )
        );
        break;
      case 2:
        bar("Deposit")
        await deposit(wallet)
          .then((res) => {
            console.log(res);
            historyList.push(
              new OperationHistory(
                OperationType.DEPOSIT,
                new Wallet(wallet.getSold())
              )
            );
          })
          .catch((err) => console.log(err.message));
        break;
      case 3:
        bar("Withdraw");
        await withdrawal(wallet)
          .then((res) => {
            console.log(res);
            historyList.push(
              new OperationHistory(
                OperationType.WITHDRAW,
                new Wallet(wallet.getSold())
              )
            );
          })
          .catch((err) => console.log(err.message));
        break;
      case 4:
        printHistory(historyList);
        break;
      case 5:
        conditionRunning = false;
        closeMyPrompt();
        console.log("Bye");
        break;
      default:
        console.log("RETRY");
    }
  }
};
