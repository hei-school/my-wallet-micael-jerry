import { Money } from "../model/money.model";
import { deposit, printMoney, withdrawal } from "../service/money.service";
import { myPrompt } from "../util/my.prompt.util";
import { bar } from "../view/bar.view";
import { printMenu } from "../view/menu.view";

export const runMoneyApp = async (money: Money) => {
  let conditionRunning: boolean = true;
  while (conditionRunning) {
    bar("Money")
    printMenu("Status", "Deposit", "Withdraw", "Exit");
    let input = await myPrompt("Choice: ");
    let choice: number = Number(input);
    while (!choice) {
      choice = Number(await myPrompt("Please enter a valid number\nChoice: "));
    }
    switch (choice) {
      case 1:
        bar("Status");
        printMoney(money);
        break;
      case 2:
        bar("Deposit");
        await deposit(money)
          .then((res) => console.log(res))
          .catch((err) => console.log(err.message));
        break;
      case 3:
        bar("Withdraw");
        await withdrawal(money)
          .then((res) => console.log(res))
          .catch((err) => console.log(err.message));
        break;
      case 4:
        conditionRunning = false;
        console.log("Bye");
        break;
      default:
        console.log("RETRY");
    }
  }
};
