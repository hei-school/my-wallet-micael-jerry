package view;

import model.History;

import java.util.List;

public class HistoryView {
    public static void printHistory(List<History> historyList) {
        BarView.bar("History");
        if (historyList.isEmpty()) {
            System.out.println("Empty history");
            return;
        }
        for (int i = 0; i < historyList.size(); i++) {
            History history = historyList.get(i);
            System.out.println((i + 1) + ". " + history.getTimestamp().toString() + " - " + history.getOperation() + " - " + "sold: " + history.getWallet().getSold());
        }
    }
}
