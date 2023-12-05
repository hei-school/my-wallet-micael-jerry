package view;

import model.History;

import java.util.List;

public class HistoryView {
    public static void printHistory(List<History> historyList) {
        System.out.println("===================== History =====================");
        for (History history : historyList) {
            System.out.println(history.getTimestamp().toString() + " - " + history.getOperation() + " - " + "sold: " + history.getWallet().getSold());
        }
    }
}
