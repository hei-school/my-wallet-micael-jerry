package service;

import model.Document;
import model.DocumentType;
import view.BarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentService {

    public static void printDocumentGroupByType(List<Document> documentList) {
        List<Document> cinList = getDocumentByType(documentList, DocumentType.CIN);
        List<Document> drivingLicenceList = getDocumentByType(documentList, DocumentType.DRIVING_LICENCE);
        List<Document> bankCardList = getDocumentByType(documentList, DocumentType.BANK_CARD);
        if (!cinList.isEmpty()) {
            BarView.bar("CIN");
            printDocument(cinList);
        }
        if (!drivingLicenceList.isEmpty()) {
            BarView.bar("Driving licence");
            printDocument(drivingLicenceList);
        }
        if (!bankCardList.isEmpty()) {
            BarView.bar("Bank card");
            printDocument(bankCardList);
        }
    }

    public static void printDocument(List <Document> documentList) {
        for (int i = 0; i < documentList.size(); i++) {
            System.out.println("N: " + (i + 1) + "\tidentifier:" + documentList.get(i).getId());
        }
    }

    public static List<Document> getDocumentByType(List<Document> documentList, DocumentType type) {
        List<Document> documents = new ArrayList<>();
        for (Document document : documentList) {
            if (document.getType() == type)
                documents.add(document);
        }
        return documents;
    }

    public static void addDocument(List<Document> documentList, Scanner sc) {
        Document document = new Document();
        System.out.println("Document type:\n\t1. CIN\n\t2. Driving Licence\n\t3. Bank Card");
        if (sc.hasNextInt()) {
            int typeVal =  sc.nextInt();
            System.out.println("Document identifier:");
            String docIdVal = sc.next();
            if (typeVal >= 1 && typeVal <= 3 && !docIdVal.isEmpty()) {
                document.setType(getTypeByNum(typeVal));
                document.setId(docIdVal);
                documentList.add(document);
            }
            else {
                System.out.println("Invalid Input - retry");
                sc.next();
            }
        } else {
            System.out.println("Invalid Input - retry");
            sc.next();
        }
    }

    public static void removeDocument(List<Document> documentList, Scanner sc) {
        printDocumentGroupByType(documentList);
        System.out.println("Type of document you want to remove:\n\t1. CIN\n\t2. Driving Licence\n\t3. Bank Card");
        if (sc.hasNextInt()) {
            int typeVal =  sc.nextInt();
            System.out.println("Document number (N):");
            if (typeVal >= 1 && typeVal <= 3 && sc.hasNextInt()) {
                if (sc.hasNextInt()) {
                    int docNumVal = sc.nextInt();
                    List<Document> documentsByType = getDocumentByType(documentList, getTypeByNum(typeVal));
                    if (documentsByType.size() >= docNumVal) {
                        Document documentRemoved = documentsByType.get(docNumVal - 1);
                        removeDocumentInList(documentList, documentRemoved);
                    }
                    else {
                        System.out.println("Invalid number - retry");
                        sc.next();
                    }
                }
                else {
                    System.out.println("Invalid Input - retry");
                    sc.next();
                }
            }
            else {
                System.out.println("Invalid Input - retry");
                sc.next();
            }
        } else {
            System.out.println("Invalid Input - retry");
            sc.next();
        }
    }

    public static void removeDocumentInList (List<Document> documentList, Document document) {
        for (int i = 0; i < documentList.size(); i++) {
            if (documentList.get(i).equals(document)) {
                documentList.remove(i);
                break;
            }
        }
    }

    private static DocumentType getTypeByNum(int n) {
        if (n == 1)
            return DocumentType.CIN;
        else if (n == 2)
            return DocumentType.DRIVING_LICENCE;
        else if (n == 3)
            return DocumentType.BANK_CARD;
        else
            return null;
    }
}
