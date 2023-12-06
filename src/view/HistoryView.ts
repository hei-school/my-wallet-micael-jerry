import { OperationHistory } from "../model/operation.history.model";

export const printHistory = (historyList: OperationHistory[]): void => {
  console.log("===================== History =====================");
  if (historyList.length == 0) {
    console.log("Empty history");
    return;
  }
  for (const history of historyList) {
    console.log(
      `${history.getTimestamp().toString()} - ${history.getOperation()} - sold: ${history.getWallet().getSold()}`
    );
  }
};
