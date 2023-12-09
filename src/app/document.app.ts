import { Document } from "../model/document";
import { addDocument, printDocumentGroupByType, removeDocument } from "../service/document.service";
import { myPrompt } from "../util/my.prompt.util";
import { bar } from "../view/bar.view";
import { printMenu } from "../view/menu.view";

export const runDocumentApp = async (documentList: Document[]) => {
  let conditionRunning: boolean = true;
  while (conditionRunning) {
    bar("Document");
    printMenu("Status", "Add", "Remove", "Exit");
    let input = await myPrompt("Choice: ");
    let choice: number = Number(input);
    switch (choice) {
      case 1:
        bar("Status");
        printDocumentGroupByType(documentList);
        break;
      case 2:
        bar("Add");
        await addDocument(documentList)
          .then((res) => console.log(res))
          .catch((err) => console.log(err.message));
        break;
      case 3:
        bar("Remove");
        await removeDocument(documentList)
          .then((res) => console.log(res))
          .catch((err) => console.log(err.message));
        break;
      case 4:
        conditionRunning = false;
        break;
      default:
        console.log("RETRY");
    }
  }
};
