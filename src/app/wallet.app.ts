import { Wallet } from "../model/wallet.model";
import { closeMyPrompt, myPrompt } from "../util/my.prompt.util";
import { printMenu } from "../view/menu.view";
import { runMoneyApp } from "./money.app";

export const run = async () => {
  let wallet: Wallet = new Wallet();

  console.log("Welcome");

  let conditionRunning: boolean = true;
  while (conditionRunning) {
    printMenu("Money", "Exit");
    let input = await myPrompt("Choice: ");
    let choice: number = Number(input);
    while (!choice) {
      choice = Number(await myPrompt("Please enter a valid number\nChoice: "));
    }
    switch (choice) {
      case 1:
        await runMoneyApp(wallet.getMoney())
        break;
      case 2:
        conditionRunning = false;
        closeMyPrompt();
        console.log("Bye");
        break;
      default:
        console.log("RETRY");
    }
  }
};
