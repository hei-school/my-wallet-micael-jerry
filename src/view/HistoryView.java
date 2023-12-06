package view;

import model.History;

import java.util.List;

public class HistoryView {
    public static void printHistory(List<History> historyList) {
        System.out.println("===================== History =====================");
        if (historyList.isEmpty()) {
            System.out.println("Empty history");
            return;
        }
        for (History history : historyList) {
            System.out.println(history.getTimestamp().toString() + " - " + history.getOperation() + " - " + "sold: " + history.getWallet().getSold());
        }
    }
}
