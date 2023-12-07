import { OperationHistory } from "../model/operation.history.model";
import { bar } from "./bar.view";

export const printHistory = (historyList: OperationHistory[]): void => {
  bar("History");
  if (historyList.length == 0) {
    console.log("Empty history");
    return;
  }
  for (let i = 0; i < historyList.length; i++) {
    console.log(
      `${i + 1}. ${historyList[i].getTimestamp().toLocaleDateString("fr")} - Operation: ${historyList[i].getOperation()} - sold: ${historyList[i].getWallet().getSold()}`
    );
  }
};
