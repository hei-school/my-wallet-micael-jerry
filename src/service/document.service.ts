import { Document } from "../model/document";
import { DocumentType, getTypeByNum } from "../model/document.type";
import { myPrompt } from "../util/my.prompt.util";
import { bar } from "../view/bar.view";

export const removeDocumentInList = (
  documentList: Document[],
  document: Document
) => {
  for (let i = 0; i < documentList.length; i++) {
    if (documentList[i] == document) {
      documentList.splice(i, 1);
      break;
    }
  }
};

export const printDocument = (documentList: Document[]): void => {
  for (let i = 0; i < documentList.length; i++) {
    console.log(`N: ${i + 1}\tidentifier: ${documentList[i].getId()}`);
  }
};

export const getDocumentByType = (
  documentList: Document[],
  type: DocumentType | null
): Document[] => {
  const documents: Document[] = [];
  for (const document of documentList) {
    if (document.getType() === type) {
      documents.push(document);
    }
  }
  return documents;
};

export const printDocumentGroupByType = (documentList: Document[]): void => {
  const cinList = getDocumentByType(documentList, DocumentType.CIN);
  const drivingLicenceList = getDocumentByType(
    documentList,
    DocumentType.DRIVING_LICENCE
  );
  const bankCardList = getDocumentByType(documentList, DocumentType.BANK_CARD);

  if (cinList.length > 0) {
    bar("CIN");
    printDocument(cinList);
  }
  if (drivingLicenceList.length > 0) {
    bar("Driving licence");
    printDocument(drivingLicenceList);
  }
  if (bankCardList.length > 0) {
    bar("Bank card");
    printDocument(bankCardList);
  }
};

export const addDocument = async (
  documentList: Document[]
): Promise<unknown> => {
  let document: Document = new Document();
  let inputType = await myPrompt(
    "Document type:\n\t1. CIN\n\t2. Driving Licence\n\t3. Bank Card\n"
  );
  if (
    !isNaN(Number(inputType)) &&
    Number(inputType) >= 1 &&
    Number(inputType) <= 3
  ) {
    let inputIdentifier = await myPrompt("Document identifier: ");
    if (String(inputIdentifier).length > 0) {
      document.setType(getTypeByNum(Number(inputType)));
      document.setId(String(inputIdentifier));
      documentList.push(document);
      return Promise.resolve("Document added successfully");
    } else {
      return Promise.reject(new Error("Invalid Input - retry"));
    }
  } else {
    return Promise.reject(new Error("Invalid Input - retry"));
  }
};

export const removeDocument = async (documentList: Document[]) => {
  printDocumentGroupByType(documentList);
  let typeDocRemoveInput = await myPrompt(
    "Type of document you want to remove:\n\t1. CIN\n\t2. Driving Licence\n\t3. Bank Card:\n"
  );
  if (
    !isNaN(Number(typeDocRemoveInput)) &&
    Number(typeDocRemoveInput) >= 1 &&
    Number(typeDocRemoveInput) <= 3
  ) {
    let typeDocRemove: DocumentType = getTypeByNum(Number(typeDocRemoveInput));
    let indexDocRemoveInput = await myPrompt("Document number (N): ");
    if (!isNaN(Number(indexDocRemoveInput))) {
      let indexDocRemove: number = Number(indexDocRemoveInput);
      let documentsByType = getDocumentByType(documentList, typeDocRemove);
      if (documentsByType.length >= indexDocRemove) {
        let documentRemoved: Document = documentsByType[indexDocRemove - 1];
        removeDocumentInList(documentList, documentRemoved);
        return Promise.resolve("Document removed successfully");
      } else {
        return Promise.reject(new Error("Invalid Input - retry"));
      }
    }
  } else {
    return Promise.reject(new Error("Invalid Input - retry"));
  }
};
